package com.example.cly.word;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WordContentFragment extends Fragment {
    private View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        view=inflater.inflate( R.layout.word_content_frag,container,false );
        return view;
    }
    public void refresh(String wordTitle,String wordName,String wordContent){
        View visibilityLayout=view.findViewById( R.id.visibility_layout );
        visibilityLayout.setVisibility( View.VISIBLE );
        TextView wordTitleText=view.findViewById( R.id.word_title);
        TextView wordNameText=view.findViewById( R.id.word_name );
        TextView wordContentText=view.findViewById( R.id.word_content );
        wordTitleText.setText( wordTitle );
        wordNameText.setText( wordName );
        wordContentText.setText( wordContent );
    }
}
