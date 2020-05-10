package org.paint.ascii;

import org.paint.ascii.exceptions.DrawFigureException;
import org.paint.ascii.render.CanvasRenderer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TextCanvas canvas = null;

        TextPainter painter = new TextPainter(System.out::print);

        while (true) {
            System.out.print("\nenter command:");
            String line = reader.readLine();
            String[] cmd = line.split(" ");
            String command = cmd[0];

            if ("Q".equals(command)) {
                return;
            }

            if ("C".equals(command)) {
                canvas = CanvasRenderer.createBorderedTextCanvas(cmd);
            }

            if (canvas == null) {
                System.out.println("No canvas created, create canvas before drawing figures.");
                continue;
            }

            try {
                CanvasRenderer.render(canvas, cmd);
                painter.printCanvas(canvas);
            } catch (DrawFigureException exception) {
                System.err.println("Failed to renders figure: " + exception.getMessage());
            }
        }
    }
}
