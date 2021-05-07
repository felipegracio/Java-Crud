import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AlunoBoudary extends Application implements EventHandler <ActionEvent> {

    private TextField  txtId = new TextField();
    private TextField  txtRa = new TextField();
    private TextField  txtNome = new TextField();
    private TextField  txtNascimento = new TextField();
    private Button bntadd = new Button("ADICIONAR");
    private Button bntpesq = new Button("PESQUISAR");

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private alunoControl control = new alunoControl();


        @Override
    public void start (Stage stage) throws Exception{

        GridPane grid = new GridPane();
            Scene scn = new Scene(grid, 400, 150);

            grid.add(new Label("Id"),0,0);
            grid.add(txtId,1,0);
            grid.add(new Label("Ra"),0,2);
            grid.add(txtRa,1,2);
            grid.add(new Label("Nome"),0,4);
            grid.add(txtNome,1,4);
            grid.add(new Label("Nascimento"),0,6);
            grid.add(txtNascimento,1,6);

            grid.add(bntadd,0,7);
            grid.add(bntpesq,1,7);

            bntadd.addEventFilter(ActionEvent.ACTION, this);
            bntpesq.addEventFilter(ActionEvent.ACTION, this);


            stage.setScene(scn);
            stage.setTitle("Cadastro Aluno");
            stage.show();

    }

    public Aluno boundaryToEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Aluno alu = new Aluno();
        try {
            alu.setNome(txtNome.getText());
            alu.setRa(txtRa.getText());
            LocalDate nas = LocalDate.parse(txtNascimento.getText(), formatter);
            alu.setNascimento(nas);

            alu.setId(Integer.parseInt(txtId.getText()));

        } catch (Exception e) {
            e.printStackTrace();

        }
        return alu;

    }

    public void entityToBoundary(Aluno alu) {
        if (alu != null){
            try {
            txtNome.setText(alu.getNome());
            txtRa.setText(alu.getRa());

            String txtData = alu.getNascimento().format(formatter);
            txtNascimento.setText(txtData);
            txtId.setText(String.valueOf(alu.getId()));



            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }






    @Override
    public void handle(ActionEvent event) {
        if(event.getSource()==bntadd){
        System.out.println("Botão ADICIONAR apertado");
        Aluno a = this.boundaryToEntity();
        control.adicionar(a);
        }
        else if (event.getSource() == bntpesq) {
            System.out.println("Botão PESQUISAR apertado");
            Aluno a = control.pesquisarPorAluno(txtNome.getText());
            this.entityToBoundary(a);
            }
        }
    }

