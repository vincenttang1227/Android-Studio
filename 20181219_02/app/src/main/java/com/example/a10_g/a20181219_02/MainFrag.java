package com.example.a10_g.a20181219_02;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainFrag extends Fragment {

    private TextView tvResult, tvTotalSet, tvYouwin, tvComWin, tvEven;
    private ImageButton btnSci, btnPaper, btnStone;
    private ImageView ivCompGue;
    private Button btnRst;

    private int totalset = 0, youwin = 0, comwin = 0, even = 0;

    public MainFrag() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        return inflater.inflate(R.layout.frag_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        ivCompGue = getView().findViewById(R.id.iv_compGue);
        tvResult = getView().findViewById(R.id.tv_result);
        btnPaper = getView().findViewById(R.id.btn_paper);
        btnSci = getView().findViewById(R.id.btn_sci);
        btnStone = getView().findViewById(R.id.btn_stone);
        btnRst = getView().findViewById(R.id.btn_rst);

        tvTotalSet = getActivity().findViewById(R.id.tv_totalSet);
        tvYouwin = getActivity().findViewById(R.id.tv_youwin);
        tvComWin = getActivity().findViewById(R.id.tv_comwin);
        tvEven = getActivity().findViewById(R.id.tv_even);

        btnPaper.setOnClickListener(btnPaperListener);
        btnStone.setOnClickListener(btnStoneListener);
        btnSci.setOnClickListener(btnSciListener);
        btnRst.setOnClickListener(btnRstListener);
    }

    private Button.OnClickListener btnRstListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            totalset = 0;
            comwin = 0;
            youwin = 0;
            even = 0;
            tvTotalSet.setText(getString(R.string.zero));
            tvYouwin.setText(getString(R.string.zero));
            tvComWin.setText(getString(R.string.zero));
            tvEven.setText(getString(R.string.zero));
            tvResult.setText(getString(R.string.result));
            ivCompGue.setImageResource(R.drawable.ic_launcher_background);
        }
    };

    private ImageButton.OnClickListener btnPaperListener = new ImageButton.OnClickListener() {
        @Override
        public void onClick(View v) {
            int com = (int) (Math.random() * 3 + 1);
            totalset++;
            tvTotalSet.setText(String.valueOf(totalset));

            //1-剪刀 2-石頭 3-布
            if (com == 1) {
                ivCompGue.setImageResource(R.drawable.scissor);
                tvResult.setText(getString(R.string.result) + getString(R.string.lose));
                comwin++;
                tvComWin.setText(String.valueOf(comwin));
            } else if (com == 2) {
                ivCompGue.setImageResource(R.drawable.stone);
                tvResult.setText(getString(R.string.result) + getString(R.string.win));
                youwin++;
                tvYouwin.setText(String.valueOf(youwin));
            } else {
                ivCompGue.setImageResource(R.drawable.paper);
                tvResult.setText(getString(R.string.result) + getString(R.string.even));
                even++;
                tvEven.setText(String.valueOf(even));
            }
        }
    };

    private Button.OnClickListener btnStoneListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            int com = (int) (Math.random() * 3 + 1);
            totalset++;
            tvTotalSet.setText(String.valueOf(totalset));

            //1-剪刀 2-石頭 3-布
            if (com == 1) {
                ivCompGue.setImageResource(R.drawable.scissor);
                tvResult.setText(getString(R.string.result) + getString(R.string.win));
                youwin++;
                tvYouwin.setText(String.valueOf(youwin));
            } else if (com == 2) {
                ivCompGue.setImageResource(R.drawable.stone);
                tvResult.setText(getString(R.string.result) + getString(R.string.even));
                even++;
                tvEven.setText(String.valueOf(even));
            } else {
                ivCompGue.setImageResource(R.drawable.paper);
                tvResult.setText(getString(R.string.result) + getString(R.string.lose));
                comwin++;
                tvComWin.setText(String.valueOf(comwin));
            }
        }
    };

    private Button.OnClickListener btnSciListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
                int com = (int) (Math.random() * 3 + 1);
                totalset++;
                tvTotalSet.setText(String.valueOf(totalset));

            //1-剪刀 2-石頭 3-布
            if (com == 1) {
                ivCompGue.setImageResource(R.drawable.scissor);
                tvResult.setText(getString(R.string.result) + getString(R.string.even));
                even++;
                tvEven.setText(String.valueOf(even));
            } else if (com == 2) {
                ivCompGue.setImageResource(R.drawable.stone);
                tvResult.setText(getString(R.string.result) + getString(R.string.lose));
                comwin++;
                tvComWin.setText(String.valueOf(comwin));
            } else {
                ivCompGue.setImageResource(R.drawable.paper);
                tvResult.setText(getString(R.string.result) + getString(R.string.win));
                youwin++;
                tvYouwin.setText(String.valueOf(youwin));
            }
        }
    };
}
