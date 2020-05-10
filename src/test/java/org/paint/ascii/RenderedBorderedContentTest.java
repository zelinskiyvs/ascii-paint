package org.paint.ascii;

import org.junit.Before;
import org.junit.Test;
import org.paint.ascii.exceptions.DrawFigureException;
import org.paint.ascii.render.CanvasRenderer;

import static org.junit.Assert.assertEquals;


public class RenderedBorderedContentTest {
    private TextPainter painter;
    private StringBuilder resultPicture;
    private BorderedTextCanvas canvas;

    @Before
    public void init() {
        canvas = new BorderedTextCanvas(20, 5, 'x', ' ');
        resultPicture = new StringBuilder();
        painter = new TextPainter(resultPicture::append);
    }

    @Test
    public void testHorizontalLine() throws DrawFigureException {
        String expectedPicture = "" +
                "----------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|xxxxxxx             |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------\n";
        String[] command = {"L", "1", "3", "7", "3"};
        CanvasRenderer.render(canvas, command);
        painter.printCanvas(canvas);
        assertEquals(expectedPicture, resultPicture.toString());
    }


    @Test
    public void testVerticalLine() throws DrawFigureException {
        String expectedPicture = "" +
                "----------------------\n" +
                "|      x             |\n" +
                "|      x             |\n" +
                "|      x             |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------\n";
        String[] command = {"L", "7", "1", "7", "3"};
        CanvasRenderer.render(canvas, command);
        painter.printCanvas(canvas);
        assertEquals(expectedPicture, resultPicture.toString());
    }

    @Test
    public void testIntersectedLines() throws DrawFigureException {
        String expectedPicture = "" +
                "----------------------\n" +
                "|    xxxxxx          |\n" +
                "|      x             |\n" +
                "|      x             |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------\n";
        String[] line1 = {"L", "5", "1", "10", "1"};
        String[] line2 = {"L", "7", "1", "7", "3"};
        CanvasRenderer.render(canvas, line1);
        CanvasRenderer.render(canvas, line2);
        painter.printCanvas(canvas);
        assertEquals(expectedPicture, resultPicture.toString());
    }

    @Test
    public void testObliqueLineLeft() throws DrawFigureException {
        String expectedPicture = "" +
                "----------------------\n" +
                "|xx                  |\n" +
                "|  xxx               |\n" +
                "|     xx             |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------\n";
        String[] command = {"L", "1", "1", "7", "3"};
        CanvasRenderer.render(canvas, command);
        painter.printCanvas(canvas);
        assertEquals(expectedPicture, resultPicture.toString());
    }

    @Test
    public void testObliqueLineRight() throws DrawFigureException {
        String expectedPicture = "" +
                "----------------------\n" +
                "|     xx             |\n" +
                "|  xxx               |\n" +
                "|xx                  |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------\n";
        String[] command = {"L", "1", "3", "7", "1"};
        CanvasRenderer.render(canvas, command);
        painter.printCanvas(canvas);
        assertEquals(expectedPicture, resultPicture.toString());
    }

    @Test
    public void testRectangle() throws DrawFigureException {
        String expectedPicture="" +
                "----------------------\n" +
                "|                    |\n" +
                "|              xxxxxx|\n" +
                "|              x    x|\n" +
                "|              x    x|\n" +
                "|              xxxxxx|\n" +
                "----------------------\n";
        String[] command = {"R", "15", "2", "20", "5"};
        CanvasRenderer.render(canvas, command);
        painter.printCanvas(canvas);
        assertEquals(expectedPicture, resultPicture.toString());
    }

    @Test
    public void testRectangleAndLine() throws DrawFigureException {
        String expectedPicture="" +
                "----------------------\n" +
                "|xxxxxxxxxxxxxxxxxxxx|\n" +
                "|x                  x|\n" +
                "|x              xx  x|\n" +
                "|x            xx    x|\n" +
                "|x          xx      x|\n" +
                "|x        xx        x|\n" +
                "|x      xx          x|\n" +
                "|x    xx            x|\n" +
                "|x                  x|\n" +
                "|xxxxxxxxxxxxxxxxxxxx|\n" +
                "----------------------\n";
        canvas = new BorderedTextCanvas(20, 10, 'x', ' ');
        String[] rectangle = {"R", "1", "1", "20", "10"};
        CanvasRenderer.render(canvas, rectangle);
        String[] line = {"L", "6", "8", "17", "3"};
        CanvasRenderer.render(canvas, line);
        painter.printCanvas(canvas);
        assertEquals(expectedPicture, resultPicture.toString());
    }
}