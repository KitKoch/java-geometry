# Java Geometry

Collection of small, **geometry** programs in Java. Each subobject is a
standalone app with unit tests

## Modules
- **two-lines-intersection** - intersection of 2 infinite lines through
**Cramer's rule**
- **linear-equation-solver** - solves a 2x2 linear system using **Cramer's rule**
- **point-in-circle-checker** - checks if `(x, y)` lies inside a circle (any center/radius)
- **point-in-rectangle-checker** - checks if `(x, y)` lies inside or on a rectangle (any center/width/height)
- **triangle-perimeter-calculator** - reads 3 edge lengths, validate if they can form a triangle

## Run
```bash
git clone https://github.com/KitKoch/java-geometry.git
cd java-geometry

# build & run test
./gradlew clean build
./gradlew :linear-equation-solver:test
./gradlew :two-lines-intersection:test
./gradlew :point-in-circle-checker:test  
./gradlew :point-in-rectangle-checker:test  
./gradlew :triangle-perimeter-calculator:test  

# run specific modules
./gradlew :linear-equation-solver:run --console=plain
./gradlew :two-lines-intersection:run --console=plain
./gradlew :point-in-circle-checker:run --console=plain
./gradlew :point-in-rectangle-checker:run --console=plain
./gradlew :triangle-perimeter-calculator:run --console=plain

