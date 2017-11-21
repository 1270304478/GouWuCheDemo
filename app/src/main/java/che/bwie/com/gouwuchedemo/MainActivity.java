package che.bwie.com.gouwuchedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import che.bwie.com.gouwuchedemo.bean.ShopBean;
import che.bwie.com.gouwuchedemo.presenter.MainPresenter;
import che.bwie.com.gouwuchedemo.view.MainViewListener;

public class MainActivity extends AppCompatActivity implements MainViewListener {

    @Bind(R.id.third_recyclerview)
    RecyclerView thirdRecyclerview;
    @Bind(R.id.third_allselect)
    CheckBox thirdAllselect;
    @Bind(R.id.third_totalprice)
    TextView thirdTotalprice;
    @Bind(R.id.third_totalnum)
    TextView thirdTotalnum;
    @Bind(R.id.third_submit)
    TextView thirdSubmit;
    @Bind(R.id.third_pay_linear)
    LinearLayout thirdPayLinear;
    private MainPresenter presenter;
    private ShopAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
        presenter.getData();
        adapter = new ShopAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


        thirdRecyclerview.setLayoutManager(manager);
        thirdRecyclerview.setAdapter(adapter);


        adapter.setListener(new ShopAdapter.UpdateUiListener() {
            @Override
            public void setTotal(String total, String num,boolean allCheck) {

                thirdAllselect.setChecked(allCheck);
                thirdTotalnum.setText(num);
                thirdTotalprice.setText(total);
            }
        });
    }
    @Override
    public void success(ShopBean bean) {


        adapter.add(bean);


    }

    @Override
    public void failure(Exception e) {

        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @OnClick(R.id.third_allselect)
    public void onViewClicked() {

        adapter.selectAll(thirdAllselect.isChecked());


    }
}
