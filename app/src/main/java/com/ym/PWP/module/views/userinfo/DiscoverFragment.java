package com.ym.PWP.module.views.userinfo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.ym.PWP.module.contract.UserInfoContract;
import com.ym.mvpdemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.maxwin.view.XListView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DiscoverFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DiscoverFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiscoverFragment extends Fragment implements UserInfoContract.IDiscoverFragment, XListView.IXListViewListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    private XListView xListView;
    private String[] event_name = { "2016年广州阅动羊城公益徒步", "2017满天星公益阅读夏令营志愿者招募", "2016广州城乡汇都市农耕交流会", "满天星公益兴仁馆第四期志愿者招募","满天星第四届青年公益领袖计划" };

    private String[] summery = { "2016年广州阅动羊城公益徒步2016年广州阅动羊城公益徒步2016年广州阅动羊城公益徒步",
            "2017满天星公益阅读夏令营志愿者招募2017满天星公益阅读夏令营志愿者招募2017满天星公益阅读夏令营志愿者招募",
            "2016广州城乡汇都市农耕交流会2016广州城乡汇都市农耕交流会2016广州城乡汇都市农耕交流会",
            "满天星公益兴仁馆第四期志愿者招募满天星公益兴仁馆第四期志愿者招募满天星公益兴仁馆第四期志愿者招募",
            "满天星第四届青年公益领袖计划满天星第四届青年公益领袖计划满天星第四届青年公益领袖计划" };
    private String[] release_time = {"22小时前|100次阅读","22小时前|100次阅读","22小时前|100次阅读","22小时前|100次阅读","22小时前|100次阅读"};

    private int[] picture_ids = { R.drawable.default_image1, R.drawable.default_image1,
            R.drawable.default_image1, R.drawable.default_image1,R.drawable.app_icon };

    public DiscoverFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiscoverFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiscoverFragment newInstance(String param1, String param2) {
        DiscoverFragment fragment = new DiscoverFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_discover, container, false);

        List<Map<String, Object>> listems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < event_name.length; i++) {
            Map<String, Object> listem = new HashMap<String, Object>();
            listem.put("picture_ids", picture_ids[i]);
            listem.put("event_name", event_name[i]);
            listem.put("summery", summery[i]);
            listem.put("release_time", release_time[i]);
            listems.add(listem);
        }
        SimpleAdapter simplead = new SimpleAdapter(getContext(),listems,
                R.layout.event_card_list, new String[] { "event_name", "picture_ids", "summery","release_time" },
                new int[] {R.id.tv_title,R.id.img_news,R.id.tv_date,R.id.tv_content});
        xListView= (XListView) view.findViewById(R.id.xlistView);
        xListView.setAdapter(simplead);

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
//                R.layout.event_card_list ,getData());
//        xListView.setAdapter(arrayAdapter);
        xListView.setXListViewListener(this);//实现IXListViewListener 监听事件
        xListView.setPullLoadEnable(true);//实现上拉刷新（较早的数据）
        xListView.setPullRefreshEnable(true);//实现下拉刷新（当前页面的数据）
        return view;

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

//    private List<String> getData(){
//        List<String> data = new ArrayList<String>();
//        for (int i=0;i<3;i++){
//            data.add(i+"");
//        }
//        return data;
//    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

//    @Override
//    public void onFragmentInteraction(Uri uri) {
//
//    }

    @Override
    public void showdata() {

    }

    @Override
    public void setPresenter(UserInfoContract.IUserInfoFragmentPresenter mIFragmentPresenter) {

    }

    @Override
    public void onRefresh() {
//        initFileAsynctask();
    }

    @Override
    public void onLoadMore() {
//        mPageNum++;
//        new FileAsynctask().execute(Constants.PATH_XIAOZU_LV+mPageNum);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
