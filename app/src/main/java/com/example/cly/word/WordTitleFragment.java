package com.example.cly.word;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordTitleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_word_title, container, false );
        RecyclerView wordTitleRecyclerView = (RecyclerView)view.findViewById( R.id.word_title_recycler_view );
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        wordTitleRecyclerView.setLayoutManager(layoutManager);
        WordAdapter adapter=new WordAdapter(getWord());
        wordTitleRecyclerView.setAdapter(adapter);
        return view;
    }

    class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder>{
        private List<Word> mWordList;
        public WordAdapter(List<Word> mWordList){
            this.mWordList=mWordList;
        }
        class ViewHolder extends RecyclerView.ViewHolder{
            TextView wordTitleText;
            //TextView wordNameText;
            public ViewHolder(View view){
                super(view);
                wordTitleText=(TextView)view.findViewById( R.id.word_title );
                //wordNameText=(TextView)view.findViewById( R.id.word_name );
            }
        }
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view=LayoutInflater.from( parent.getContext() ).inflate( R.layout.word_item,parent,false );
            final ViewHolder holder=new ViewHolder( view );
            view.setOnClickListener( new View.OnClickListener(){
                public void onClick(View v){
                    Word word=mWordList.get( holder.getAdapterPosition() );
                    WordContentActivity.actionStart( getActivity(),word.getTitle(),word.getName(),word.getContent() );
                }
            } );
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Word word=mWordList.get(position);
            holder.wordTitleText.setText(word.getTitle());
            //holder.wordNameText.setText( word.getName() );
        }

        @Override
        public int getItemCount() {
            return mWordList.size();
        }

    }
    private List<Word> getWord(){
        List<Word> wordList=new ArrayList <>(  );
        for(int i=1;i<=50;i++){
            Word word=new Word();
            word.setTitle( "This is word title"+i );
            word.setName( "123" );
            word.setContent( getRandomLengthContent("This is word content"+i+".") );
            wordList.add(word);
        }
        return wordList;
    }
    private String getRandomLengthContent(String content){
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<length;i++){
            builder.append(content);
        }
        return builder.toString();
    }
}
