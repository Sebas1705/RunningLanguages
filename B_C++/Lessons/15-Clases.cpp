#include <iostream>
#include <cstdlib>
using namespace std;

class Human{
    
    protected:
        //Attributes:
        string name;
        unsigned short age;
        string* hobbies;

    public:
    
        //Constructor:
        Human(string name, unsigned short age){
            this->name=name;
            this->age=age;
            this->hobbies=(string*)malloc(sizeof(string)*3);
            this->hobbies[0]="Football";
            this->hobbies[1]="Basketball";
            this->hobbies[2]="Video games";
        }

        //Methods:
        void let(string action){
            letPrivate(action);
        }

        void printInfo(){
            cout<<name<< " with "<<age<<" years"<<endl;
            for(unsigned short i=0;i<3;i++)cout<<this->hobbies[i]<<" \n";
            cout<<endl;
        }

        ~Human(){
            free(hobbies);
        }
    
    private:
    
        void letPrivate(string action){
            cout << name << " is " << action << endl;
        }
};

class Student : public Human{
    private:
        string id;

    public:
        Student(string name,unsigned short age) : Human(name,age){
            this->id="2828282d";
        }

        void printInfoS(){
            cout<<"ID: "<<this->id<<endl;
            printInfo();
        }

        ~Student(){
            free(this->hobbies);
        }
};

//Template on array:
template<typename T, int N>
class Array{
    private:
        T my_array[N];
        const int n=N;
    public:
        int getSize(){ return n; }
};

int main(){
    
    Human *h=new Human("Pedro",19);

    h->let("running");
    h->printInfo();

    Student *s=new Student("Juan",89);
    s->printInfoS();

    Array<int,10> arr;
    cout<<"Size: "<<arr.getSize()<<endl;

    Human *h=new Student("Pedro",19);//Polymorphism
    return 0;
}
