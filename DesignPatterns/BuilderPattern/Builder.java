package DesignPatterns.BuilderPattern;

public interface Builder {
    Builder setLength(long length);

    Builder setBreadth(long breadth);

    Builder setHeight(long height);
}
