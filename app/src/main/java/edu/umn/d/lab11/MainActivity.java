package edu.umn.d.lab11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements MainView {
    private EditText editTextVertexLabel;
    private TextView nameOfVertex;
    private EditText editTextEdge;
    private EditText editTextEdge2;
    private DrawingCanvas drawingCanvas;
    private List<VertexVisual> vertices = new ArrayList<>();
    private Presenter presenter;
    private int counter = 0;
    private static final String TAG = "DemoInitialApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            drawingCanvas = findViewById(R.id.drawingCanvas);
            editTextVertexLabel = findViewById(R.id.editTextVertexLabel);
            editTextEdge = findViewById(R.id.editTextEdge);
            editTextEdge2 = findViewById(R.id.editTextEdge2);
            nameOfVertex = findViewById(R.id.nameOfVertex);
            Random rand = new Random();

            // Create vertex button
            Button createVertexButton = findViewById(R.id.button);
            createVertexButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Added Vertex", Toast.LENGTH_SHORT).show();

                    String vertexName = editTextVertexLabel.getText().toString();

                    counter++;
                    TextView text = (TextView) findViewById(R.id.numberVertices);
                    text.setText("Number Of Vertices: " + counter);

                    int maxX = 1000;
                    int maxY = 1900;
                    int minX = 20;
                    int minY = 720;

                    int randomX = rand.nextInt((maxX - minX) + 1) + minX;
                    int randomY = rand.nextInt((maxY - minY) + 1) + minY;

                    VertexVisual vertex = new VertexVisual(vertexName, randomX, randomY, 20);
                    drawingCanvas.addVertex(vertex);
                    vertices.add(vertex);

                    nameOfVertex.setText("Added Vertex: " + vertexName);
                }
            });

            // Create edge button
            Button btnCreateEdge = findViewById(R.id.createEdge);
            btnCreateEdge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String vertexName1 = editTextEdge.getText().toString();
                    String vertexName2 = editTextEdge2.getText().toString();

                    VertexVisual vertex1 = findVertexName(vertexName1);
                    VertexVisual vertex2 = findVertexName(vertexName2);

                    if (vertex1 != null && vertex2 != null) {
                        float distance = edgeDistance(vertex1, vertex2);

                        EdgeVisual edge = new EdgeVisual(vertex1, vertex2, distance);
                        drawingCanvas.addEdge(edge);
                        Toast.makeText(getApplicationContext(), "Added Edge", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "One Or More Vertex Not Found", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            // Clear graph button
            Button clearGraphButton = findViewById(R.id.clearGraph);
            clearGraphButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vertices.clear();
                    drawingCanvas.clearEdges();
                    drawingCanvas.clearVertices();
                    counter = 0;
                    TextView text = findViewById(R.id.numberVertices);
                    text.setText("Number Of Vertices: " + counter);
                    Toast.makeText(getApplicationContext(), "Graph Cleared", Toast.LENGTH_SHORT).show();
                    nameOfVertex.setText("Added Vertex: ");
                }
            });

            // Sample graph button
            Button sampleGraph = findViewById(R.id.sampleGraph);
            sampleGraph.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    vertices.clear();
                    drawingCanvas.clearEdges();
                    drawingCanvas.clearVertices();

                    int randomX;
                    int randomY;
                    int maxX = 1000;
                    int maxY = 1900;
                    int minX = 20;
                    int minY = 720;

                    randomX = rand.nextInt((maxX - minX) + 1) + minX;
                    randomY = rand.nextInt((maxY - minY) + 1) + minY;
                    VertexVisual v0 = new VertexVisual("v0", randomX, randomY, 20);
                    drawingCanvas.addVertex(v0);
                    vertices.add(v0);

                    randomX = rand.nextInt((maxX - minX) + 1) + minX;
                    randomY = rand.nextInt((maxY - minY) + 1) + minY;
                    VertexVisual v1 = new VertexVisual("v1", randomX, randomY, 20);
                    drawingCanvas.addVertex(v1);
                    vertices.add(v1);

                    randomX = rand.nextInt((maxX - minX) + 1) + minX;
                    randomY = rand.nextInt((maxY - minY) + 1) + minY;
                    VertexVisual v2 = new VertexVisual("v2", randomX, randomY, 20);
                    drawingCanvas.addVertex(v2);
                    vertices.add(v2);

                    randomX = rand.nextInt((maxX - minX) + 1) + minX;
                    randomY = rand.nextInt((maxY - minY) + 1) + minY;
                    VertexVisual v3 = new VertexVisual("v3", randomX, randomY, 20);
                    drawingCanvas.addVertex(v3);
                    vertices.add(v3);

                    randomX = rand.nextInt((maxX - minX) + 1) + minX;
                    randomY = rand.nextInt((maxY - minY) + 1) + minY;
                    VertexVisual v4 = new VertexVisual("v4", randomX, randomY, 20);
                    drawingCanvas.addVertex(v4);
                    vertices.add(v4);

                    randomX = rand.nextInt((maxX - minX) + 1) + minX;
                    randomY = rand.nextInt((maxY - minY) + 1) + minY;
                    VertexVisual v5 = new VertexVisual("v5", randomX, randomY, 20);
                    drawingCanvas.addVertex(v5);
                    vertices.add(v5);

                    randomX = rand.nextInt((maxX - minX) + 1) + minX;
                    randomY = rand.nextInt((maxY - minY) + 1) + minY;
                    VertexVisual v6 = new VertexVisual("v6", randomX, randomY, 20);
                    drawingCanvas.addVertex(v6);
                    vertices.add(v6);

                    EdgeVisual edge1 = new EdgeVisual(v0, v1, edgeDistance(v0, v1));
                    drawingCanvas.addEdge(edge1);

                    EdgeVisual edge2 = new EdgeVisual(v0, v2, edgeDistance(v0, v2));
                    drawingCanvas.addEdge(edge2);

                    EdgeVisual edge3 = new EdgeVisual(v1, v3, edgeDistance(v1, v3));
                    drawingCanvas.addEdge(edge3);

                    EdgeVisual edge4 = new EdgeVisual(v1, v4, edgeDistance(v1, v4));
                    drawingCanvas.addEdge(edge4);

                    EdgeVisual edge5 = new EdgeVisual(v2, v5, edgeDistance(v2, v5));
                    drawingCanvas.addEdge(edge5);

                    EdgeVisual edge6 = new EdgeVisual(v2, v6, edgeDistance(v2, v6));
                    drawingCanvas.addEdge(edge6);

                    TextView text = findViewById(R.id.numberVertices);
                    text.setText("Number Of Vertices: " + 7);
                    nameOfVertex.setText("Added Sample Graph");
                }
            });
            return insets;
        });
    }

    /**
     * Finds the name of the most recently added vertex
     * @param name
     * @return
     */
    @Override
    public VertexVisual findVertexName(String name) {
        for (VertexVisual vertex : vertices) {
            if (vertex.getVertexName().equals(name)) {
                return vertex;
            }
        }
        return null;
    }


    /**
     * Calculates distance between vertices
     * @param v1
     * @param v2
     * @return
     */
    @Override
    public float edgeDistance(VertexVisual v1, VertexVisual v2) {
        float dx = v2.getX() - v1.getX();
        float dy = v2.getY() - v1.getY();
        return (int) Math.sqrt(dx * dx + dy * dy);
    }
}

