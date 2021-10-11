package com.example.imagelover.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.imagelover.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Shapes extends AppCompatActivity {
    private ImageView square,circle;
    private ImageButton circle_btn,square_btn,Undo_btn;
    private Stack<Integer> stack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes);
        stack=new Stack<>();
        square=findViewById(R.id.squaret);
        circle=findViewById(R.id.circle);
        circle_btn=findViewById(R.id.circlebtn);
        square_btn=findViewById(R.id.squarebtn);
        Undo_btn=findViewById(R.id.undobtn);
        circle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(circle.getAlpha()==0) {
                    circle.setAlpha(1f);
                    stack.add(1);
                }
            }
        });
        square_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(square.getAlpha()==0) {
                    square.setAlpha(1f);
                    stack.add(2);
                }
            }
        });
        Undo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stack.size()!=0){
                    if(stack.peek()==1) {
                        circle.setAlpha(0f);
                        stack.pop();
                    }
                    else if(stack.peek()==2){
                        square.setAlpha(0f);
                        stack.pop();
                    }
                }
                else{
                    Toast.makeText(Shapes.this, "Insert Shape First", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}