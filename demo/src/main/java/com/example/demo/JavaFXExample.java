package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.DiTich;
import com.example.model.LeHoi;
import com.example.model.ListLichSu;
import com.example.model.SuKien;
import com.example.model.TrieuDai;
import com.example.model.Vua;
import com.example.scraper.ScrapAll;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JavaFXExample extends Application {
    private List<Vua> vuas;
    private List<TrieuDai> trieuDais;
    private List<SuKien> suKiens;
    private List<LeHoi> leHois;
    private List<DiTich> diTichs;

    // private List<Vua> vuas;
    @Override
    public void start(Stage stage) throws IOException {
        ListLichSu listLichSu = new ListLichSu();
        ScrapAll.scrapAll(listLichSu);

        vuas = listLichSu.getVuas();
        trieuDais = listLichSu.getTrieuDais();
        suKiens = listLichSu.getSuKiens();
        leHois = listLichSu.getLeHois();
        diTichs = listLichSu.getDiTichs();

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        ListView<String> listView1 = new ListView<>();
        listView1.getItems().add("Danh sách các Vua");
        listView1.getItems().add("Danh sách các Triều đại");
        listView1.getItems().add("Danh sách các Di tích");
        listView1.getItems().add("Danh sách các Sự kiện");
        listView1.getItems().add("Danh sách các Lễ hội");
        root.setLeft(listView1);

        listView1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            BorderPane root2 = new BorderPane();
            root2.setPadding(new Insets(10));

            if (newValue.equals("Danh sách các Vua")) {
                ListView<String> listView2 = new ListView<>();
                for (Vua vua : listLichSu.getVuas()) {
                    listView2.getItems().add(vua.getTen());
                }
                root2.setLeft(listView2);
                TextArea textArea3 = new TextArea();
                textArea3.setEditable(false);
                root.setCenter(textArea3);
                listView2.getSelectionModel().selectedItemProperty()
                        .addListener((observable2, oldValue2, newValue2) -> {
                            Vua selectedVua = null;
                            for (Vua vua : vuas) {
                                if (vua.getTen().equals(newValue2)) {
                                    selectedVua = vua;
                                    break;
                                }
                            }
                            TextArea textArea2 = new TextArea();
                            textArea2.setEditable(false);
                            root2.setCenter(textArea2);
                            if (selectedVua != null) {
                                textArea2.setText(
                                        "Tên: " + selectedVua.getTen() + "\nNgày sinh: " + selectedVua.getNgaysinh()
                                                + "\n" + "Ngày mất: " + selectedVua.getNgaymat() + "\n"
                                                + "Ngày lên ngôi: " + selectedVua.getNgaylenngoi() + "\n" + "Cha: " +
                                                selectedVua.getCha());
                            }

                        });
            }

            if (newValue.equals("Danh sách các Triều đại")) {
                ListView<String> listView2 = new ListView<>();
                for (TrieuDai trieuDai : listLichSu.getTrieuDais()) {
                    listView2.getItems().add(trieuDai.getTen());
                }
                root2.setLeft(listView2);

                BorderPane root3 = new BorderPane();
                root3.setPadding(new Insets(10));

                root2.setCenter(root3);

                listView2.getSelectionModel().selectedItemProperty()
                        .addListener((observable2, oldValue2, newValue2) -> {
                            TrieuDai selected = null;
                            for (TrieuDai trieuDai : trieuDais) {
                                if (trieuDai.getTen().equals(newValue2)) {
                                    selected = trieuDai;
                                    break;
                                }
                            }

                            if (selected != null) {
                                TextArea textArea2 = new TextArea();
                                textArea2.setEditable(false);
                                root3.setTop(textArea2);

                                textArea2.setText("Tên: " + selected.getTen());

                                BorderPane root4 = new BorderPane();
                                Label title = new Label("Danh sách các Vua: ");
                                root4.setTop(title);

                                ListView<String> listView3 = new ListView<>();
                                for (Vua vua : selected.getCacVua()) {
                                    listView3.getItems().add(vua.getTen());
                                }
                                root4.setCenter(listView3);
                                root3.setCenter(root4);

                                listView3.getSelectionModel().selectedItemProperty()
                                        .addListener((observable3, oldValue3, newValue3) -> {
                                            Vua selectedVua = null;
                                            for (Vua vua : vuas) {
                                                if (vua.getTen().equals(newValue3)) {
                                                    selectedVua = vua;
                                                    break;
                                                }
                                            }
                                            if (selectedVua != null) {
                                                TextArea textArea3 = new TextArea();
                                                textArea3.setEditable(false);
                                                root.setRight(textArea3);
                                                textArea3.setText(
                                                        "Tên: " + selectedVua.getTen() + "\nNgày sinh: "
                                                                + selectedVua.getNgaysinh()
                                                                + "\n" + "Ngày mất: " + selectedVua.getNgaymat() + "\n"
                                                                + "Ngày lên ngôi: " + selectedVua.getNgaylenngoi()
                                                                + "\n" + "Cha: " +
                                                                selectedVua.getCha());
                                            }

                                        });
                            }

                        });
            }

            if (newValue.equals("Danh sách các Di tích")) {
                ListView<String> listView2 = new ListView<>();
                for (DiTich diTich : diTichs) {
                    listView2.getItems().add(diTich.getTen());
                }
                root2.setLeft(listView2);
                TextArea textArea4 = new TextArea();
                textArea4.setEditable(false);
                root.setRight(textArea4);
                listView2.getSelectionModel().selectedItemProperty()
                        .addListener((observable2, oldValue2, newValue2) -> {
                            TextArea textArea2 = new TextArea();
                            textArea2.setEditable(false);
                            root2.setCenter(textArea2);

                            TextArea textArea3 = new TextArea();
                            textArea3.setEditable(false);
                            root.setRight(textArea3);
                            DiTich selectedVua = null;
                            for (DiTich diTich : diTichs) {
                                if (diTich.getTen().equals(newValue2)) {
                                    selectedVua = diTich;
                                    break;
                                }
                            }
                            if (selectedVua != null) {
                                textArea2.setText(
                                        "Tên di tích: " + selectedVua.getTen() + "\n\nĐịa điểm: "
                                                + selectedVua.getDiadiem()
                                                + "\n" + "Loại di tích: " + selectedVua.getLoaiditich());
                            }

                        });
            }

            if (newValue.equals("Danh sách các Sự kiện")) {
                ListView<String> listView2 = new ListView<>();
                for (SuKien suKien : suKiens) {
                    listView2.getItems().add(suKien.getTen());
                }
                root2.setLeft(listView2);
                TextArea textArea4 = new TextArea();
                textArea4.setEditable(false);
                root.setRight(textArea4);
                BorderPane root3 = new BorderPane();
                root3.setPadding(new Insets(10));

                root2.setCenter(root3);

                listView2.getSelectionModel().selectedItemProperty()
                        .addListener((observable2, oldValue2, newValue2) -> {
                            TextArea textArea2 = new TextArea();
                            textArea2.setEditable(false);
                            root3.setTop(textArea2);
                            SuKien selected = null;
                            for (SuKien suKien : suKiens) {
                                if (suKien.getTen().equals(newValue2)) {
                                    selected = suKien;
                                    break;
                                }
                            }

                            if (selected != null) {
                                textArea2.setText("Tên: " + selected.getTen());

                                BorderPane root4 = new BorderPane();
                                Label title = new Label("Danh sách các nhân vật liên quan:");
                                root4.setTop(title);

                                ListView<String> listView3 = new ListView<>();
                                for (Vua vua : selected.getVuas()) {
                                    listView3.getItems().add(vua.getTen());
                                }
                                root4.setCenter(listView3);
                                root3.setCenter(root4);

                                listView3.getSelectionModel().selectedItemProperty()
                                        .addListener((observable3, oldValue3, newValue3) -> {
                                            Vua selectedVua = null;
                                            for (Vua vua : vuas) {
                                                if (vua.getTen().equals(newValue3)) {
                                                    selectedVua = vua;
                                                    break;
                                                }
                                            }
                                            if (selectedVua != null) {
                                                TextArea textArea3 = new TextArea();
                                                textArea3.setEditable(false);
                                                root.setRight(textArea3);
                                                textArea3.setText(
                                                        "Tên: " + selectedVua.getTen() + "\nNgày sinh: "
                                                                + selectedVua.getNgaysinh()
                                                                + "\n" + "Ngày mất: " + selectedVua.getNgaymat() + "\n"
                                                                + "Ngày lên ngôi: " + selectedVua.getNgaylenngoi()
                                                                + "\n" + "Cha: " +
                                                                selectedVua.getCha());
                                            }

                                        });
                            }

                        });
            }

            // lễ hội
            if (newValue.equals("Danh sách các Lễ hội")) {
                ListView<String> listView2 = new ListView<>();
                for (LeHoi leHoi : leHois) {
                    listView2.getItems().add(leHoi.getTen());
                }
                root2.setLeft(listView2);
                TextArea textArea4 = new TextArea();
                textArea4.setEditable(false);
                root.setRight(textArea4);
                BorderPane root3 = new BorderPane();
                root3.setPadding(new Insets(10));

                root2.setCenter(root3);

                listView2.getSelectionModel().selectedItemProperty()
                        .addListener((observable2, oldValue2, newValue2) -> {
                            LeHoi selected = null;
                            for (LeHoi leHoi : leHois) {
                                if (leHoi.getTen().equals(newValue2)) {
                                    selected = leHoi;
                                    break;
                                }
                            }
                            BorderPane root4 = new BorderPane();
                            root3.setCenter(root4);
                            ListView<String> listView3 = new ListView<>();
                            ListView<String> listView4 = new ListView<>();
                            ListView<String> listView5 = new ListView<>();

                            if (selected != null) {
                                TextArea textArea2 = new TextArea();
                                textArea2.setEditable(false);
                                root3.setTop(textArea2);
                                textArea2.setText("Tên: " + selected.getTen() + "\nĐịa điểm: " + selected.getDiadiem()
                                        + "\nNgày tổ chức: " + selected.getNgaytochuc());

                                BorderPane root5 = new BorderPane();
                                Label title = new Label("Danh sách các nhân vật liên quan:");
                                root5.setTop(title);

                                for (Vua vua : selected.getCacvua()) {
                                    listView3.getItems().add(vua.getTen());
                                }
                                root5.setCenter(listView3);

                                root4.setLeft(root5);

                                listView3.getSelectionModel().selectedItemProperty()
                                        .addListener((observable3, oldValue3, newValue3) -> {
                                            Vua selectedVua = null;
                                            for (Vua vua : vuas) {
                                                if (vua.getTen().equals(newValue3)) {
                                                    selectedVua = vua;
                                                    break;
                                                }
                                            }
                                            TextArea textArea3 = new TextArea();
                                            textArea3.setEditable(false);
                                            root.setRight(textArea3);
                                            if (selectedVua != null) {
                                                textArea3.setText(
                                                        "Tên: " + selectedVua.getTen() + "\nNgày sinh: "
                                                                + selectedVua.getNgaysinh()
                                                                + "\n" + "Ngày mất: " + selectedVua.getNgaymat() + "\n"
                                                                + "Ngày lên ngôi: " + selectedVua.getNgaylenngoi()
                                                                + "\n" + "Cha: " +
                                                                selectedVua.getCha());
                                            }

                                        });

                                //
                                BorderPane root6 = new BorderPane();
                                Label title2 = new Label("Danh sách các Sự kiện liên quan:");
                                root6.setTop(title2);

                                for (SuKien suKien : selected.getCacsukien()) {
                                    listView4.getItems().add(suKien.getTen());
                                }
                                root6.setCenter(listView4);

                                root4.setCenter(root6);

                                listView4.getSelectionModel().selectedItemProperty()
                                        .addListener((observable3, oldValue3, newValue3) -> {
                                            SuKien selectedVua = null;
                                            for (SuKien suKien : suKiens) {
                                                if (suKien.getTen().equals(newValue3)) {
                                                    selectedVua = suKien;
                                                    break;
                                                }
                                            }

                                            if (selectedVua != null) {
                                                TextArea textArea3 = new TextArea();
                                                textArea3.setEditable(false);
                                                root.setRight(textArea3);
                                                textArea3.setText("Tên: " + selectedVua.getTen());
                                            }

                                        });
                                //

                                //
                                //
                                BorderPane root7 = new BorderPane();
                                Label title3 = new Label("Danh sách các Di tích liên quan:");
                                root7.setTop(title3);

                                for (DiTich diTich : selected.getCacditich()) {
                                    listView5.getItems().add(diTich.getTen());
                                }
                                root7.setCenter(listView5);

                                root4.setRight(root6);

                                listView5.getSelectionModel().selectedItemProperty()
                                        .addListener((observable3, oldValue3, newValue3) -> {
                                            DiTich selectedVua = null;
                                            for (DiTich diTich : diTichs) {
                                                if (diTich.getTen().equals(newValue3)) {
                                                    selectedVua = diTich;
                                                    break;
                                                }
                                            }
                                            if (selectedVua != null) {
                                                textArea2.setText(
                                                        "Tên di tích: " + selectedVua.getTen() + "\n\nĐịa điểm: "
                                                                + selectedVua.getDiadiem()
                                                                + "\n" + "Loại di tích: "
                                                                + selectedVua.getLoaiditich());
                                            }

                                        });
                                //
                                //

                            }

                        });
            }

            root.setCenter(root2);
        });

        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Danh sách các vua");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class Vuas {
        private List<Vua> vuas = new ArrayList<>();
    }

    private static class Trieudais {
        private List<TrieuDai> trieuDais = new ArrayList<>();
    }

    private static class Ditichs {
        private List<DiTich> diTichs = new ArrayList<>();
    }

    private static class Sukiens {
        private List<SuKien> suKiens = new ArrayList<>();
    }

    private static class Lehois {
        private List<LeHoi> leHois = new ArrayList<>();
    }
}

