package stringConverting;

public class PathConverter {

    public PathConverter() {

    }

    public StringBuilder getMapsPath(StringBuilder pathsData) {
        StringBuilder mapsPath = new StringBuilder();

        try {
            String buffer = pathsData.substring(pathsData.indexOf("'"));
            buffer = buffer.substring(1);
            buffer = buffer.substring(0, buffer.indexOf("'"));
            mapsPath.append(buffer);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return mapsPath;
    }

    public StringBuilder getSettingsPath(StringBuilder pathsData) {
        StringBuilder settingsPath = new StringBuilder();

        try {
            String buffer = pathsData.substring(pathsData.indexOf(")"));
            buffer = buffer.substring(buffer.indexOf("'"));
            buffer = buffer.substring(1);
            buffer = buffer.substring(0, buffer.indexOf("'"));

            settingsPath.append(buffer);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return settingsPath;
    }
}
