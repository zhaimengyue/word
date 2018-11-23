package com.example.cly.word;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class WordContentActivity extends AppCompatActivity {
    public static void actionStart(Context context, String wordTitle,String wordName, String wordContext){
        Intent intent=new Intent( context,WordContentActivity.class );
        intent.putExtra( "wordtitle",wordTitle );
        intent.putExtra( "wordname",wordName );
        intent.putExtra( "wordContent",wordContext );
        context.startActivity( intent );
    }
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate( savedInstanceState );
        setContentView( R.layout.word_content );
        String word_Title=getIntent().getStringExtra( "wordtitle" );
        String word_Name=getIntent().getStringExtra( "wordname" );
        String word_Content=getIntent().getStringExtra( "wordcontent" );
        WordContentFragment wordContentFragment=(WordContentFragment)getSupportFragmentManager().findFragmentById( R.id.word_content_fragment );
        wordContentFragment.refresh(word_Title,word_Name,word_Content);

    }
}
