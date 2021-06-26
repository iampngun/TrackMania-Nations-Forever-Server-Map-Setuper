import filework.FileWorker;
import stringConverting.LayoutConverter;
import stringConverting.PathConverter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileWorker fileWorker = new FileWorker();
        PathConverter pathConverter = new PathConverter();
        LayoutConverter layoutConverter = new LayoutConverter();

        StringBuilder pathsData = fileWorker.readFile("PathsSettings.txt");

        StringBuilder mapsPath = pathConverter.getMapsPath(pathsData);
        StringBuilder settingsPath = pathConverter.getSettingsPath(pathsData);

        List<String> mapList = fileWorker.getMapList(mapsPath.toString());
        StringBuilder mapsLayout = layoutConverter.getMapsLayout(mapList, mapsPath.toString());

        StringBuilder settingsData = fileWorker.readFile(settingsPath.toString());
        StringBuilder settingsLayout = layoutConverter.getSettigsLayout(settingsData, mapsLayout);

        fileWorker.writeFile(settingsLayout.toString(), settingsPath.toString(), false);
    }
}
