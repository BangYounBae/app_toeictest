package com.example.toeic_test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView Question, Counter;
    private RadioButton Choice_1, Choice_2, Choice_3, Choice_4;
    private Button Start_Next_button;
    private RadioGroup myAnswers;
    String Question_set[] = {"Where should I put this key? You can___ it on the shelf.",
            "The man told us that the next train would arrive____.",
            "When____ leaving for Toronto,Canada? We are planning to set out at 10 o'clock.",
            "I can meet you at Central Station. WILL___?",
            "You are welcome to order the goods now. But payment should be made ___?",
            "I cannot understand my neighbor's accent. I wish she would ___.",
            "I don't have any results for you today. I ___ tomorrow.",
            "I really have to go now. I have ___ the doctor",
            "How ___ a crowd had gethered at the scene of the accident? I don't know exactly.but there were a lot of schocked onlookers.",
            "Do you know ___ that buliding is? I would say that It was bulit at least 100 years ago.",
            //11
            "In order to remain competitive, we have to ____ the deadline in any circumstances.",
            "The candidate with the most outstanding qualifications will be ___ in the final round of the interview.",
            "Most co-workers agreed that Michael has ____ to closing the contract successfully.",
            "All workers are required to ___ with safety regulations such as wearing a hard hat.",
            //15
            "The director has ___ the managers that the company is accepting applications for the regional manager position. ",
            "Several measures to ___ energy consumption in the building are expected to be implemented.",
            "Please ___ one of our technicians when you find any problems with electrical equipment.",
            "Benson Energy is expected to ___ a multi-year contract for procuring crude oil with Flint Petroleum.",
            "In spite of its rigorous cost-cutting program, the company is expected to ___ the current project within budget.",
            //20
            "As part of its plan to ___ up for the loss from the sales decrease, the firm is planning a extensive promotional events.",
            "The invoice indicates that the order for paper clips and file folders was ___ last month when our company was preparing an orientation.",
            "The hiring committee is presently ___ for a security manager who can work on weekends.",
            "Several independent studies show that our lithium batteries ___ 40 percent longer than our rival’s.",
            "The consultant is expected to ___concerns about investment risks that the investors might have.",
            "Especially for new customers, this Web site will ___ for our company’s policies and regulations in detail.",


    };
    String Answers_set[][] = {{"hang", "deposit", "sit", "put"}, {"at three thirty", "at three thirty 0clock", "in three thirty", "in three thirty 0'clock"},
            {"are we", "we will", "will us", "are us"}, {"convenient for you", "that convenient", "that be convenient", "you be convenient"},
            {"for advance", "advancing", "in advance", "to advance"},
            {"speak clearer", "clearer speak", "more clearly speak", "speak more clearly"},
            {"have any", "may have any", "have some", "may have some"},
            {"appointments to", "an appointment to", "appointment with", "an appointment with"},
            {"large", "often", "many", "much"},
            {"old", "how age", "how old", "which age"},
            {"exclude", "install", "raise", "meet"},
            {"selected", "lasted", "exhibited", "prevented"},
            {"compiled", "specialized", "contributed", "depended"},
            {"follow", "observe", "comply", "keep"},
            {"announced", "mentioned", "noticed", "informed"},
            {"curb", "relocate","represent","acquire"},
            {"differ", "contact","forward", "speculate"},
            {"talk", "notice","sign","inform"},
            {"alleviate", "raise","complete","replace"},
            {"make","abandon","assess","aim"},
            {"made","designated","enrolled","reformed"},
            {"looking","finding","expecting", "associating"},
            {"inaugurate","last","establish","prevent"},
            {"address","comment","remark", "assure"},
            {"explain", "account","describe","inform"}



    };
    ///Answers_set[0][0] -> Seattle
    ///Answers_set[1][3] -> 3
    ///Answers_set
    int Correct_answers[] = {4, 1, 1, 4, 3, 4, 4, 4, 4, 3,3,1,1,1,4,1,2,3,3,1,1,1,2,1,2};//정답들
    int User_answers[] = new int[10];

    int Question_ID = 0;
    int Question_number = 10;

    int Test_status = 0;
    int problem_num[] =new int[10];
    Random random = new Random();

    String new_question [] = new String[10];
    int new_answers [] = new int [10];
    int num_list[] = new int[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Question = (TextView) findViewById(R.id.question);
        Counter = (TextView) findViewById(R.id.counter);
        Choice_1 = (RadioButton) findViewById(R.id.rb_1);
        Choice_2 = (RadioButton) findViewById(R.id.rb_2);
        Choice_3 = (RadioButton) findViewById(R.id.rb_3);
        Choice_4 = (RadioButton) findViewById(R.id.rb_4);


        Choice_1.setVisibility(View.INVISIBLE);
        Choice_2.setVisibility(View.INVISIBLE);
        Choice_3.setVisibility(View.INVISIBLE);
        Choice_4.setVisibility(View.INVISIBLE);

        Start_Next_button = (Button) findViewById(R.id.bt_start_Next);
        myAnswers = (RadioGroup) findViewById(R.id.myanswers);
    }

    public void click_Start_Next(View view) {
        /// new

        int x;
        int l = 0;
        int total = 0;

        while(true){
            if (l == 10) {
                break;
            }


            x=random.nextInt(25);

            problem_num[l] = x;
            l +=1;

        }
        for ( int k = 0 ; k<10;k++){
            new_question[k] = Question_set[problem_num[k]];
            new_answers[k] = Correct_answers[problem_num[k]];

        }

        if (Test_status == 0) {
            Choice_1.setVisibility(View.VISIBLE);
            Choice_2.setVisibility(View.VISIBLE);
            Choice_3.setVisibility(View.VISIBLE);
            Choice_4.setVisibility(View.VISIBLE);
            myAnswers.clearCheck();  // myAnswers -- RadioGroup에 체크된 것이 있다면 지운다
            Start_Next_button.setText("Next");  // 버튼의 글씨는 Next로 바꾼다
            if (Question_ID < Question_number) {
                Question.setText(new_question[Question_ID]);
                Counter.setText(Question_ID + 1 + " of " + Question_number);
                Choice_1.setText(Answers_set[problem_num[Question_ID]][0]);
                Choice_2.setText(Answers_set[problem_num[Question_ID]][1]);
                Choice_3.setText(Answers_set[problem_num[Question_ID]][2]);
                Choice_4.setText(Answers_set[problem_num[Question_ID]][3]);
                num_list[Question_ID]=problem_num[Question_ID];
            } else {   /// SetVisibility INVISIBLE 테스트가 끝나면 라디오 버튼들을 안보이게끔 하는것
                ///VISIBLE 는 보이게끔하는것
                Question.setText(" \n");
                Choice_1.setVisibility(View.INVISIBLE);
                Choice_2.setVisibility(View.INVISIBLE);
                Choice_3.setVisibility(View.INVISIBLE);
                Choice_4.setVisibility(View.INVISIBLE);
                Test_status = 1;
                Start_Next_button.setText("Check");
            }

            Question_ID++;
        } else if (Test_status == 1) /// process "Check"
        {
            int num = 0;
            for (int i = 0; i < Question_number; i++) {
                num = i+1;
                if (new_answers[i] == User_answers[i]) {
                    ///correct

                    Question.setText(Question.getText().toString() +" Q#" + num + "/"+num_list[i] + ": Correct\n");
                    total += 10;
                } else {
                    ///wrong
                    Question.setText(Question.getText().toString() +" Q#" + num + "/"+num_list[i] + ": wrong" +"("+User_answers[i]+"/"+new_answers[i]+")"+"\n");
                }

            }

            Question.setText(Question.getText().toString()+ "Total:" +total+"\n");
            Test_status = 2;
            Start_Next_button.setVisibility(View.INVISIBLE);
        }
    }

    public void click_answer_1(View view) {
        User_answers[Question_ID - 1] = 1;
    }

    public void click_answer_2(View view) {
        User_answers[Question_ID - 1] = 2;
    }

    public void click_answer_3(View view) {
        User_answers[Question_ID - 1] = 3;
    }

    public void click_answer_4(View view) {
        User_answers[Question_ID - 1] = 4;
    }
}