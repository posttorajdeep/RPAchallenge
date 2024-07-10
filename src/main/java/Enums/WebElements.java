package Enums;

public enum WebElements {

    COMPANYNAME ("//label[contains(text(),'Company Name')]/following-sibling::input");
    private final String Xpath;
    WebElements(String Xpath) {
        this.Xpath = Xpath;
    }
    public String getXpath() {
        return Xpath;
    }
}
