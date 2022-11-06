#include "Matrix3.h"

Matrix3::Matrix3(int m00, int m10, int m20, int m01, int m11, int m21, int m02, int m12, int m22) 
    : data{{m00,m10,m20},{m01,m11,m21},{m02,m12,m22}} { }

int Matrix3::get(int x, int y) {
    return data[x][y];
}

Matrix3 operator+(Matrix3 rhs) {
    std::vector<std::vector<int>> new_data;
    int i, j;
    
    for(i = 0; i < 3; ++i)
        for(j = 0; j < 3; ++j)
            new_data[i][j] = this.data[i][j] + rhs.data[i][j];
}

std::ostream& operator<<(std::ostream out, Matrix3 m) {

}

std::istream& operator>>(std::istream in, Matrix3 m) {

}
