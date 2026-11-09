import javax.swing.*;
import java.awt.*;

public class SourceEditorWorkspace{

    public static void main(String[] args) {

        // Main Frame
        JFrame frame = new JFrame("Source Editor Workspace");

        frame.setSize(700, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // LEFT COMPONENT: File List

        String[] files = {
            "Main.java",
            "Engine.java",
            "config.properties",
            "styles.css"
        };

        JList<String> fileList = new JList<>(files);

        JScrollPane leftScroll = new JScrollPane(fileList);

        // RIGHT TOP: Code Editor

        JTextArea editor = new JTextArea();

        editor.setEditable(false);

        editor.setText(
            "public class Main {\n" +
            "    public static void main(String[] args) {\n" +
            "        System.out.println(\"Hello Java\");\n" +
            "    }\n" +
            "}"
        );

        JScrollPane editorScroll = new JScrollPane(editor);

        // RIGHT BOTTOM: Terminal Logs

        JTextArea terminal = new JTextArea();

        terminal.setEditable(false);

        terminal.setText(
            "[INFO] Starting build...\n" +
            "[INFO] Compiling Java files...\n" +
            "[INFO] Build completed without errors."
        );

        JScrollPane terminalScroll = new JScrollPane(terminal);

        // INNER SPLIT PANE: Top and Bottom

        JSplitPane innerSplit = new JSplitPane(
            JSplitPane.VERTICAL_SPLIT,
            editorScroll,
            terminalScroll
        );

        innerSplit.setDividerLocation(220);

        // OUTER SPLIT PANE: Left and Right

        JSplitPane outerSplit = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT,
            leftScroll,
            innerSplit
        );

        outerSplit.setOneTouchExpandable(true);

        outerSplit.setDividerLocation(180);

        // Add to JFrame

        frame.add(outerSplit);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}