# Java Geometry

Collection of small, **geometry** programs in Java. Each subobject is a
standalone app with unit tests

## Modules
- **two-lines-intersection** - intersection of 2 infinite lines through
Cramer's rule
- **linear-equation-solver** - solves a 2x2 linear system using **Cramer's rule**

## Run
```bash
git clone https://github.com/KitKoch/java-geometry.git
cd java-geometry

# build & run test
./gradlew clean build
./gradlew :linear-equation-solver:test
./gradlew :two-lines-intersection:test 

# run specific modules
./gradlew :linear-equation-solver:run --console=plain
./gradlew :two-lines-intersection:run --console=plain

