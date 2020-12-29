package builder;

public class ComplexTerrainBuilder implements TerrainBuilder{

    Terrain t = new Terrain();
    @Override
    public TerrainBuilder buildWall() {

        t.w = new Wall(1, 2, 3, 4);
        return this;
    }

    @Override
    public TerrainBuilder buildFort() {

        t.f = new Fort(1,2,3,4);
        return this;
    }

    @Override
    public TerrainBuilder buildMine() {

        t.m = new Mine(1,2,3,4);
        return this;
    }

    @Override
    public Terrain build() {
        return t;
    }

}

class Test {

    public static void main(String[] args) {
        ComplexTerrainBuilder ctb = new ComplexTerrainBuilder();
        Terrain terrain = ctb.buildFort().buildMine().buildWall().build();
        System.out.println(terrain);

    }
}