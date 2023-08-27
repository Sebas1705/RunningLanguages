#include <iostream>
#include <fstream>

#define CLEAN

using namespace std;

float media(string filename);
void clean(string filename);

int main(int argc, char *argv[]) {

    string vo_file = "./Version_original/Tiempos.txt";
    string vme_file = "./Version_Maestro-Esclavo/Tiempos.txt";

    cout << "->Recopilación datos de las pruebas:" << endl;
    cout << "+---------------------------------------------\\" << endl;
    cout << "|Media Version_Original: " << media(vo_file) << endl;
    cout << "|Media Version_Maestro-Esclavo: " << media(vme_file) << endl;
    cout << "+---------------------------------------------/" << endl;

#ifdef CLEAN
    clean(vo_file);
    clean(vme_file); 
#endif

    return 0;
}

float media(string filename) {
    std::ifstream in(filename);
    int count=0;
    float sum=0;
    while(!in.eof()){
		std::string temp;
		in>>temp;
		sum+=stof(temp);
        count++;
	}
    in.close();
    return sum/count;
}

void clean(string filename) {
    std::ofstream out(filename);
    out << "";
    out.close();
}