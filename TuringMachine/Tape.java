package turing;

public class Tape {

    private Cell currentCell;

    public Tape() {
        currentCell = new Cell();
        currentCell.content = ' ';
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public char getContent() {
        return currentCell.content;
    }

    public void setContent(char ch) {
        currentCell.content = ch;
    }

    public void moveLeft() {
        if (currentCell.prev == null) {
            Cell newCell = new Cell();
            newCell.content = ' ';
            newCell.prev = currentCell;
            currentCell.prev = newCell;
            currentCell = newCell;
        } else {
            currentCell = currentCell.prev;
        }
    }

    public void moveRight() {
        if (currentCell.next == null) {
            Cell newCell = new Cell();
            newCell.content = ' ';
            newCell.next = currentCell;
            currentCell.next = newCell;
            currentCell = newCell;
        } else {
            currentCell = currentCell.next;
        }
    }

    public String getTapeContents() {
        String contents = "";
        Cell current = currentCell;
        while (current != null) {
            contents += current.content;
            current = current.next;
        }
        return contents.trim();
    }

}
