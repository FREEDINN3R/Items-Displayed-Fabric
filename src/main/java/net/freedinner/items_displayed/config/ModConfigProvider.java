package net.freedinner.items_displayed.config;

public class ModConfigProvider implements SimpleConfig.DefaultConfig {
    private String configContents = "";

    public void addField(String key, Object value) {
        configContents += key + "=" + value + "\n";
    }

    public void addComment(String comment) {
        configContents += "# " + comment + "\n";
    }

    @Override
    public String get(String namespace) {
        return configContents;
    }
}