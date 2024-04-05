package edu.umn.d.lab11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements MainView {
    int counter = 0;
    private Presenter presenter;
    private EditText editTextText2;
    private TextView nameOfVertex;

    private static final String TAG = "DemoInitialApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn = (Button) findViewById(R.id.button);

        editTextText2 = findViewById(R.id.editTextText2);
        nameOfVertex = findViewById(R.id.nameOfVertex);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("DemoInitialApp", "This button adds a vertex");
                    Toast.makeText(getApplicationContext(), "Added Vertex", Toast.LENGTH_SHORT).show();

                    counter++;
                    TextView text = (TextView) findViewById(R.id.numberVertices);
                    text.setText ("Number Of Vertices: " + counter);

                    String vertexName = editTextText2.getText().toString();
                    presenter.addVertexClick(vertexName);
                }

            });

            /** Temporarily removing DrawingCanvas functionality */
          //  DrawingCanvas dc = findViewById(R.id.drawingCanvas);
            presenter = new Presenter(this);

    }

    @Override
    public void addVertexClick() {

    }

    @Override
    public void recentVertex(String vertexName) {
        nameOfVertex.setText("Name Of Vertex: " + vertexName);
    }
}

