enum ElemType {
    STRING("Рядок"),
    INT("Ціле число"),
    DOUBLE("Дробне число");

    final String name;

    ElemType(String name) { this.name = name; }

    @Override
    public String toString() { return this.name; }
}
