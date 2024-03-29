package idv.jerryexcc.fivelittleonclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MyClickClass myListener = new MyClickClass();//new 出有實作OnClick的物件
    private View.OnClickListener listener = new View.OnClickListener() {//直接new出監聽器
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "new出一個新的監聽器", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {//匿名
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "匿名監聽", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(this);

        Button btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(listener);

        Button btn5 = findViewById(R.id.button5);
        btn5.setOnClickListener(myListener);
    }

    public void click(View view) {//XML的Button直接呼叫
        Toast.makeText(MainActivity.this, "XML呼叫public Click()方法", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {//Interface實作
        Toast.makeText(MainActivity.this, "Activity實作OnClickListener", Toast.LENGTH_SHORT).show();
    }

    private class MyClickClass implements View.OnClickListener {//透過其他類別並把該物件new出來
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "內部類別實作OnClickListener", Toast.LENGTH_SHORT).show();
        }
    }
}
