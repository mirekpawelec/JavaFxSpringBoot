package pl.javafx.spring.model.enums;

public enum FxmlView {
	MAIN("/fxml/MainPanel.fxml", "Glowne okno"), PERSON_ADD("/fxml/PersonAdd.fxml",
			"Dodaj"), PERSON_LIST("/fxml/PersonList.fxml", "Lista");

	private String path;
	private String title;

	private FxmlView(String path, String title) {
		this.path = path;
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public String getTitle() {
		return title;
	}
}
