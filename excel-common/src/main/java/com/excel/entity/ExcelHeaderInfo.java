package com.excel.entity;

public class ExcelHeaderInfo {

    /**
     * 标题的首行坐标
     */
    private int firstRow;

    /**
     * 标题的末行坐标
     */
    private int lastRow;

    /**
     * 标题的首列坐标
     */
    private int firstCol;

    /**
     * 标题的首行坐标
     */
    private int lastCol;

    /**
     * 标题
     */
    private String title;

    public ExcelHeaderInfo(int firstRow, int lastRow, int firstCol, int lastCol, String title) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.firstCol = firstCol;
        this.lastCol = lastCol;
        this.title = title;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public void setFirstRow(int firstRow) {
        this.firstRow = firstRow;
    }

    public int getLastRow() {
        return lastRow;
    }

    public void setLastRow(int lastRow) {
        this.lastRow = lastRow;
    }

    public int getFirstCol() {
        return firstCol;
    }

    public void setFirstCol(int firstCol) {
        this.firstCol = firstCol;
    }

    public int getLastCol() {
        return lastCol;
    }

    public void setLastCol(int lastCol) {
        this.lastCol = lastCol;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
