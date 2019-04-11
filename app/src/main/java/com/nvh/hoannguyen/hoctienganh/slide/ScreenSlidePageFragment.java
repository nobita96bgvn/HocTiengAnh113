package com.nvh.hoannguyen.hoctienganh.slide;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.nvh.hoannguyen.hoctienganh.R;
import com.nvh.hoannguyen.hoctienganh.cauhoi.cauhoi;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment {

    ArrayList<cauhoi> arr_Ques;
    public static final String ARG_PAGE="page";
    public static final String ARG_CHECKANSWER="checkanswer";
    private int mpagenumber; //Vị trí trang hiện tại
    public int checkAns;

    TextView tvNum,tvQuestion;
    RadioGroup radioGroup;
    RadioButton radA,radB,radC,radD;
    ImageView imgIcon;


    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

        tvNum= (TextView) rootView.findViewById(R.id.tvNum);
        tvQuestion=(TextView) rootView.findViewById(R.id.tvQuestion);
        radA=(RadioButton) rootView.findViewById(R.id.radA);
        radB=(RadioButton) rootView.findViewById(R.id.radB);
        radC=(RadioButton) rootView.findViewById(R.id.radC);
        radD=(RadioButton) rootView.findViewById(R.id.radD);
        radioGroup=(RadioGroup) rootView.findViewById(R.id.radGroup);
        imgIcon=(ImageView) rootView.findViewById(R.id.ivIcon);



        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arr_Ques=new ArrayList<cauhoi>();
        ScreenSlideActivity slideActivity= (ScreenSlideActivity) getActivity();
        arr_Ques=slideActivity.getData();
        mpagenumber=getArguments().getInt(ARG_PAGE);
        checkAns=getArguments().getInt(ARG_CHECKANSWER);

    }

    public static ScreenSlidePageFragment create(int pageNumber,int checkanswer){
        ScreenSlidePageFragment fragment= new ScreenSlidePageFragment();
        Bundle args= new Bundle();
        args.putInt(ARG_PAGE,pageNumber);
        args.putInt(ARG_CHECKANSWER,checkanswer);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvNum.setText("Câu "+(mpagenumber+1));
        tvQuestion.setText(arr_Ques.get(mpagenumber).getCauhoi());
        radA.setText(getItem(mpagenumber).getDapana());
        radB.setText(getItem(mpagenumber).getDapanb());
        radC.setText(getItem(mpagenumber).getDapanc());
        radD.setText(getItem(mpagenumber).getDapand());

        imgIcon.setImageResource(getResources().getIdentifier(getItem(mpagenumber).getAnh()+"","drawable","com.nvh.hoannguyen.hoctienganh"));

        if (checkAns !=0){
            radA.setClickable(false);
            radB.setClickable(false);
            radC.setClickable(false);
            radD.setClickable(false);
            getCheckAns(getItem(mpagenumber).getKetqua().toString());
        }


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                getItem(mpagenumber).choiceID=checkedId;
                getItem(mpagenumber).setTraloi(getChoiceFromID(checkedId));
            }
        });

    }

    public cauhoi getItem(int position){
        return arr_Ques.get(position);
    }


    //lấy giá trị (vị trí) radiobutton chuyển thành đáp án A/B/C/D

    private String getChoiceFromID(int ID){
        if (ID == R.id.radA){
            return ("A");
        }else if (ID == R.id.radB){
            return ("B");
        }else if (ID == R.id.radC){
            return ("C");
        }else if (ID == R.id.radD){
            return ("D");
        }else return ("");
    }

    //hàm kiểm tra câu đúng. chuyển background của câu đúng.
    private void getCheckAns(String ans){
        if (ans.equals("A")==true){
            radA.setBackgroundColor(Color.RED);
        }
        else if (ans.equals("B")==true) {
            radB.setBackgroundColor(Color.RED);
        }
        else if (ans.equals("C")==true) {
            radC.setBackgroundColor(Color.RED);
        }
        else if (ans.equals("D")==true) {
            radD.setBackgroundColor(Color.RED);
        }else ;
    }


}
