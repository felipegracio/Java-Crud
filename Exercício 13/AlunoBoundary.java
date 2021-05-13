import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.LongStringConverter;


public class AlunoBoundary extends Application {
    private TextField txtNome = new TextField();
    private TextField txtId = new TextField();
    private TextField txtRa = new TextField();
    private TextField txtNasc = new TextField();
    private AlunoControl control = new AlunoControl();
    private Button btnAdd = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");

    @Override
    public void start(Stage stage) throws Exception{
        GridPane gp = new GridPane();
        Scene scn = new Scene(gp, 300, 200);
        gp.add(new Label("Nome"), 0, 0);
        gp.add(txtNome, 1, 0);
        gp.add(new Label("RA"), 0, 1);
        gp.add(txtRa, 1, 1);
        gp.add(new Label("ID"), 0, 2);
        gp.add(txtId, 1, 2);
        gp.add(new Label("Nascimento"), 0, 3);
        gp.add(txtNasc, 1, 3);
        gp.add(btnAdd, 0, 4);
        gp.add(btnPesquisar, 1, 4);
        btnAdd.setOnAction((e) -> { control.adicionar();});
        btnPesquisar.setOnAction((e) -> { control.pesquisarPorNome();});
        StringConverter conversorStringLong = new LongStringConverter();

        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(txtRa.textProperty(), control.raProperty());
        Bindings.bindBidirectional(txtId.textProperty(), control.idProperty(), conversorStringLong);
        Bindings.bindBidirectional(txtNasc.textProperty(), control.nascimentoProperty());

        stage.setScene(scn);
        stage.setTitle("Gestão de Alunos");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}