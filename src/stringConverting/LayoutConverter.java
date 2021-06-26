package stringConverting;

import java.util.List;

public class LayoutConverter {

    public LayoutConverter() {

    }

    public StringBuilder getMapsLayout(List<String> mapList, String mapsPath) {
        StringBuilder mapsLayout = new StringBuilder();

        for (String s : mapList) {
            String mapLayout = "\n\t<challenge>\n\t\t<file>" + mapsPath + "/" + s + "</file>\n\t</challenge>";
            mapsLayout.append(mapLayout);
        }

        return mapsLayout;
    }

    public StringBuilder getSettigsLayout(StringBuilder settingsData, StringBuilder mapsLayout) {
        StringBuilder settingsLayout = new StringBuilder();

        String buffer = settingsData.substring(0, settingsData.indexOf("<startindex>"));
        buffer += "<startindex>0</startindex>" + mapsLayout + "\n</playlist>";

        settingsLayout.append(buffer);

        return settingsLayout;
    }
}
