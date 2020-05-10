package org.paint.ascii.render;

import org.paint.ascii.BorderedTextCanvas;
import org.paint.ascii.Canvas;
import org.paint.ascii.FigureValidator;
import org.paint.ascii.TextCanvas;
import org.paint.ascii.exceptions.DrawFigureException;
import org.paint.ascii.model.Line;
import org.paint.ascii.model.Rectangle;

import java.util.Arrays;

public class CanvasRenderer {

    public static void render(Canvas canvas, String[] cmd) throws DrawFigureException {
        String command = cmd[0];
        switch (command){
            case "L" : {
                render(canvas, FigureParser.parseLine(cmd));
                break;
            }
            case "R" : {
                render(canvas, FigureParser.parseRectangle(cmd));
                break;
            }
            default: {
                System.out.println("Unknown command was received: " + Arrays.toString(cmd));
            }
        }

    }

    public static TextCanvas createBorderedTextCanvas(String[] cmd){

        int width = Integer.parseInt(cmd[1]);
        int height = Integer.parseInt(cmd[2]);
        return new BorderedTextCanvas(width, height, 'x', ' ');
    }
    private static void render(Canvas canvas, Line line) throws DrawFigureException {
        FigureValidator.INSTaNCE.validate(canvas, line);
        canvas.addPoints(LineRenderer.INSTANCE.render(line));
    }

    private static void render(Canvas canvas, Rectangle rectangle) throws DrawFigureException {
        FigureValidator.INSTaNCE.validate(canvas, rectangle);
        canvas.addPoints(RectangleRenderer.INSTANCE.render(rectangle));
    }

}
