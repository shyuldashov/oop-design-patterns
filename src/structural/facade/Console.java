package structural.facade;

import java.util.ArrayList;
import java.util.List;

public class Console {
    private List<Viewport> viewportList = new ArrayList<>();
    int width, height;

    public Console(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addViewport(Viewport viewport) {
        viewportList.add(viewport);
    }

    // Facade
    public static Console newConsole(int width, int height) {
        Buffer buffer = new Buffer(width, height);
        Viewport viewport = new Viewport(buffer, width, height, 0, 0);
        Console console = new Console(width, height);
        console.addViewport(viewport);
        return console;
    }

    public void render() {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                for (Viewport viewport : viewportList) {
                    System.out.println(viewport.charAt(i, j));
                }
            }
        }
    }

}


class Main {
    public static void main(String[] args) {
        // Using Facade
        Console console = Console.newConsole(5, 10);
        console.render();

        // Low-Level API. For advanced users
        Buffer buffer = new Buffer(4, 6);
        Viewport viewport = new Viewport(buffer, 5, 8, 0, 0);
        Console console2 = new Console(4, 6);
        console2.addViewport(viewport);
        console2.render();
    }
}
