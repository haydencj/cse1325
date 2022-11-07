#include "Matrix3.h"
#include <exception>

Matrix3::Matrix3(int m00, int m10, int m20, int m01, int m11, int m21, int m02, int m12, int m22) 
    : data{{m00,m10,m20},{m01,m11,m21},{m02,m12,m22}} { }

Matrix3::Matrix3() : data{{0,0,0},{0,0,0},{0,0,0}} { }

int Matrix3::get(int x, int y) {
    if(x > 2 || x < 0) throw std::runtime_error("Y index out of range");
    if(y > 2 || y < 0) throw std::runtime_error("Y index out of range");
    return data[x][y];
}

Matrix3 Matrix3::operator+(Matrix3 rhs) {
    Matrix3 m{*this}; //hmm
    int i, j;

    for(i = 0; i < 3; ++i)
    {
        for(j = 0; j < 3; ++j)
        {
            m.data[i][j] = m.data[i][j] + rhs.data[i][j];
        }
    }

    return m;
}

std::ostream& operator<<(std::ostream& out, Matrix3& m) {
    int i, j;
    
    for(i = 0; i < 3; ++i)
    {
        for(j = 0; j < 3; ++j)
        {
            out << m.data[i][j] << " ";
        }
        out << std::endl;
    }
    return out;
}

std::istream& operator>>(std::istream& in, Matrix3& m) {
    int i, j;

    for(i = 0; i < )
}
