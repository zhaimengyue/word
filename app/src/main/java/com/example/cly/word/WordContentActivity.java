package com.example.cly.word;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class WordContentActivity extends AppCompatActivity {
    public static void actionStart(Context context, String wordName,String wordMeaning, String wordSample,String wordupdate){
        Intent intent=new Intent( context,WordContentActivity.class );
        intent.putExtra( "wordName",wordName );
        intent.putExtra( "wordMeaning",wordMeaning );
        intent.putExtra( "wordSample",wordSample );
        intent.putExtra( "wordupdate",wordupdate );
        context.startActivity( intent );
    }
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate( savedInstanceState );
        setContentView( R.layout.word_content );
        String word_Name=getIntent().getStringExtra( "wordName" );
        String word_Meaning=getIntent().getStringExtra( "wordMeaning" );
        String word_Sample=getIntent().getStringExtra( "wordSample" );
        String word_update=getIntent().getStringExtra( "wordupdate" );
        WordContentFragment wordContentFragment=(WordContentFragment)getSupportFragmentManager().findFragmentById( R.id.word_content_fragment );
        wordContentFragment.refresh(word_Name,word_Meaning,word_Sample,word_update);

    }
}
