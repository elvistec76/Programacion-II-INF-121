import math
class Vector3d:
    def __init__(self, a1, a2, a3):
        self.a1 = a1
        self.a2 = a2
        self.a3 = a3

    def __repr__(self):
        return f"({self.a1},{self.a2},{self.a3})"

    def __add__(self, other):
        return Vector3d(self.a1 + other.a1, self.a2 + other.a2, self.a3 + other.a3)

    def __sub__(self, other):
        return Vector3d(self.a1 - other.a1, self.a2 - other.a2, self.a3 - other.a3)

    def __mul__(self, r):
        return Vector3d(self.a1 * r, self.a2 * r, self.a3 * r)

    def longitud(self):
        return math.sqrt(math.pow(self.a1, 2) + math.pow(self.a2, 2) + math.pow(self.a3, 2))

    def normal(self):
        l = self.longitud()
        if l == 0:
            return Vector3d(0, 0, 0)
        else:
            return Vector3d(self.a1 / l, self.a2 / l, self.a3 / l)

    def producto_escalar(self, other):
        return self.a1 * other.a1 + self.a2 * other.a2 + self.a3 * other.a3

    def producto_vectorial(self, o):
        return Vector3d(self.a2 * o.a3 - self.a3 * o.a2, self.a3 * o.a1 - self.a1 * o.a3,
                        self.a1 * o.a2 - self.a2 * o.a1)

    def proyeccion_sobre(self, b):
        denom = math.pow(b.longitud(), 2)
        if denom == 0:
            return Vector3d(0, 0, 0)
        escalar = self.producto_escalar(b) / denom
        return b * escalar

    def componente_paralela(self, b):
        return self.proyeccion_sobre(b)

    def componente_perpendicular(self, b):
        return self - self.proyeccion_sobre(b)

    def es_ortogonal(self, b, tol=1e-9):
        return abs(self.producto_escalar(b)) <= tol

    def ortogonal_diagonales(self, b, tol=1e-9):
        d1 = (self + b).longitud()
        d2 = (self - b).longitud()
        return abs(d1 - d2) <= tol


#main

a = Vector3d(3, 2, 1)
b = Vector3d(5, 3, 2)

print("proyeccion de a sobre b:  ", a.proyeccion_sobre(b))
print("componente paralela: ", a.componente_paralela(b))
print("componente perpendicular: ", a.componente_perpendicular(b))
print("critero producto escalar: ", a.es_ortogonal(b))
print("criterio diagonal: ", a.ortogonal_diagonales(b))