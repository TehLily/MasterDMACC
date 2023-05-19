#include <iostream>
#include <vector>
#include <memory>

using namespace std;



class Pet { //Base class
public:
    Pet(){  //Constructor and methods for setting and getting info
       name = "Pet";
       age = 0;
       species = "Animal";
       gender = "Unknown";
       color = "Unknown";
    }
    void SetName(string petName){
        name = petName;
    }
    void SetSpecies(string petSpecies) {
        species = petSpecies;
    }
    void SetGender(string petGender) {
        gender = petGender;
    }
    void SetColor(string petColor) {
        color = petColor;
    }
    void SetAge(int petAge){
        age = petAge;
    }
    string GetName() {
        return name;
    }
    string GetSpecies() {
        return species;
    }
    string GetGender() {
        return gender;
    }
    string GetColor() {
        return color;
    }
    int GetAge() {
        return age;
    }
    virtual void Print() {  //Virtual print method, derived classes will override this
        cout << "Pet's name: " << name << endl;
        cout << "Pet's species: " << species << endl;
        cout << "Pet's color: " << color << endl;
        cout << "Pet's gender: " << gender << endl;
        cout << "Pet's age: " << age << " years" << endl;

    };

private:  //Only used in this class
    string name;
    string species;
    string gender;
    string color;
    int age;

};

class AquaticPet : public Pet {  //Derived class 1
public:
    AquaticPet() {  //constructors, setters, getters, and override print methods...
        waterType = "Water";
        tankSize = 0;
        }
    AquaticPet(string namePet, string speciesPet, string colorPet, int size, string salt) {
        SetName(namePet);
        SetSpecies(speciesPet);
        SetColor(colorPet);
        waterType = salt;
        tankSize = size;
    }
    void SetWaterType(string water) {
        waterType = water;
    }
    void SetTankSize(int gallons) {
        tankSize = gallons;
    }
    string GetWaterType() {
        return waterType;
    }
    int GetTankSize() {
        return tankSize;
    }
    void Print() override {
        cout << "Pet's name: " << GetName() << endl;
        cout << "Pet's species: " << GetSpecies() << endl;
        cout << "Pet's color: " << GetColor() << endl;
        cout << "Housed in a " << tankSize << "-gallon " << waterType << " tank." << endl;

    }

private:  //Only used for this class
    string waterType;
    int tankSize;
};

class HousePet : public Pet {  //Derived class 2
public:
    HousePet() {  //constructors, setters, getters, and override print methods...
        environment = "None";
        reproductiveStatus = "Unknown";
        breed = "Unknown";
        }
    HousePet(string namePet, string speciesPet, string breedPet, int agePet, string colorPet, string reproStat, string genderPet, string enviroPet) {
        SetName(namePet);
        SetSpecies(speciesPet);
        breed = breedPet;
        SetAge(agePet);
        SetColor(colorPet);
        reproductiveStatus = reproStat;
        SetGender(genderPet);
        environment = enviroPet;
    }
    void SetEnvironment(string territory) {
        environment = territory;
    }
    void SetReproStatus(string fixed) {
        reproductiveStatus = fixed;
    }
    void SetBreed(string petBreed) {
        breed = petBreed;
    }
    string GetEnvironment() {
        return environment;
    }
    string GetReproStatus() {
        return reproductiveStatus;
    }
    string GetBreed() {
        return breed;
    }
    void Print() override {
        cout << "Pet's name: " << GetName() << endl;
        cout << "Pet's species: " << GetSpecies() << endl;
        cout << "Pet's breed: " << breed << endl;
        cout << "Pet's age: " << GetAge() << endl;
        cout << "Pet's color: " <<GetColor() << endl;
        cout << "Pet's reproductive status: " << reproductiveStatus << " " << GetGender() << endl;
        cout << "Pet lives: " << environment << endl;
    }

private:  //Only used for this class
    string environment;
    string reproductiveStatus;
    string breed;
};

class PocketPet : public Pet {
public:
    PocketPet() {  //constructors, setters, getters, and override print methods...
        cageSize = 0;
        beddingType = "Unknown";
    }
    PocketPet(string namePet, string speciesPet, int agePet, string colorPet, string beddingPet, double cagePet) {
        SetName(namePet);
        SetSpecies(speciesPet);
        SetAge(agePet);
        SetColor(colorPet);
        beddingType = beddingPet;
        cageSize = cagePet;
    }
    void SetBeddingType(string bedding) {
        beddingType = bedding;
    }
    void SetCageSize(double cage) {
        cageSize = cage;
    }
    string GetBeddingType() {
        return beddingType;
    }
    double GetCageSize() {
        return cageSize;
    }
    void Print() override {
        cout << "Pet's name: " << GetName() << endl;
        cout << "Pet's species: " << GetSpecies() << endl;
        cout << "Pet's age: " << GetAge() << endl;
        cout << "Pet's color: " <<GetColor() << endl;
        cout << "Pet's bedding type: " << beddingType << endl;
        cout << "Size of cage: " << cageSize << " cubic feet" << endl;
    }

private:  //Only used in this class
    string beddingType;
    double cageSize;
};




int main() {
    vector<unique_ptr<Pet>> pets;  //Vector of smart pointers
    AquaticPet currentAqua;  //Used to add info to aquatic pet object
    HousePet currentHouse;  //Used to add info to house pet object
    PocketPet currentPocket;  //Used to add info to pocket pet object
    int mainMenuSelection = 0;  //Used for main menu entry
    int addPetOption = 0;  //Used for add pet menu entry
    int waterTypeSelect = 0;  //Used to select water type
    string currentName;  //Used for current pet name
    int currentAge;  //Used for current pet age
    string currentSpecies;  //Used for current pet species
    string currentGender;  //Used for current pet gender
    int genderSelect = 0;  //Used for gender entry
    string currentColor;  //Used for current pet color
    string currentWater;  //Used for current pet water type
    int currentTankSize;  //Used for current pet tank size
    string currentEnviron;  //Used for current pet environment
    int environSelect = 0;  //Used for environment entry
    string currentRepro;  //Used for current pet reproductive status
    int neuterSelect = 0;  //Used for neuter entry
    int spaySelect = 0;  //Used for spay entry
    string currentBreed;  //Used for current pet breed
    string currentBedding;  //Used for current pet bedding
    double currentCageSize = 0;  //Used for current pet cage size
    int index = 0;  //Used to select index
    char endProg = 'a';  //Used to indicate end of program

    while (endProg != 'q') {  //Condition for running program
        try {  //Setting up a try... catch for exceptions/errors
            cout << "Main Menu: Select an option." << endl << endl;  //Main menu...
            cout << "1. Add pet to list" << endl;
            cout << "2. Remove pet from list" << endl;
            cout << "3. Display pet list" << endl;
            cin >> mainMenuSelection;
            if(mainMenuSelection < 1 || mainMenuSelection > 3 || !cin)  //Selects for invalid entries
                throw runtime_error("Invalid Selection.");  //throws error message
            if(mainMenuSelection == 1) {  //Selects for adding pet
                cout << "Menu Option 1 Selected." << endl << endl;  //Confirms entry
                cout << "What type of pet would you like to add?" << endl;  //Prompts pet type selection...
                cout << "1. An aquatic pet" << endl;
                cout << "2. A house pet" << endl;
                cout << "3. A pocket pet" << endl;
                cin >> addPetOption;
                if(addPetOption < 1 || addPetOption > 3 || !cin) {  //Selects for invalid entries, as above...
                    throw runtime_error("Invalid Selection.");
                }
                if(addPetOption == 1) {  //Selects aquatic pet entry
                    cout << "Add Aquatic Pet Selected." << endl <<endl; //Confirms selection
                    cout << "Please enter pet's name: ";  //Prompts for information entry and accepts information...
                    cin >> currentName;

                    cout << "Please enter pet's species: ";
                    cin >> currentSpecies;

                    cout << "Please enter pet's color: ";
                    cin >> currentColor;

                    cout << "Please select water type:" << endl;
                    cout << "1. Fresh" << endl;
                    cout << "2. Salt" << endl;
                    cout << "3. Brackish" << endl;
                    cin >> waterTypeSelect;
                    if(waterTypeSelect < 1 || waterTypeSelect > 3 || !cin) {  //Selects for invalid entries, as above...
                        throw runtime_error("Invalid Selection.");
                    }
                    else if(waterTypeSelect == 1) {  //Selects for freshwater and sets info
                        currentWater = "Freshwater";
                    }
                    else if(waterTypeSelect == 2) {  //Selects for saltwater and sets info
                        currentWater = "Saltwater";
                    }
                    else if(waterTypeSelect == 3) {  //Selects for brackish water and sets info
                        currentWater = "Brackish";
                    }

                    cout << "Please enter tank size, in gallons: ";  //Prompts for tank size, in gallons
                    cin >> currentTankSize;
                    if(currentTankSize < 0 || !cin) {  //As above
                        throw runtime_error("Invalid Selection.");
                    }
                    pets.emplace_back(make_unique<AquaticPet>(currentName, currentSpecies, currentColor, currentTankSize, currentWater));  //Sends information to constructor for AquaticPet derived class and adds to vector
                }

                else if(addPetOption == 2) {  //Goes through info for house pet: prompts, inputs, selects out errors, sets, and sends back info to vector, as above with aquatic pet...
                    cout << "Add House Pet Selected." << endl <<endl;
                    cout << "Please enter pet's name: ";
                    cin >> currentName;

                    cout << "Please enter pet's species: ";
                    cin >> currentSpecies;

                    cout << "Please enter pet's breed: ";
                    cin >> currentBreed;

                    cout << "Please enter pet's age, in years: ";
                    cin >> currentAge;
                    if(currentAge < 0 || !cin) {
                        throw runtime_error("Invalid Selection.");
                    }

                    cout << "Please enter pet's color: ";
                    cin >> currentColor;

                    cout << "Please select pet's gender: " << endl;
                    cout << "1. Male" << endl;
                    cout << "2. Female" << endl;
                    cin >> genderSelect;
                    if(genderSelect < 1 || genderSelect > 2 || !cin) {
                        throw runtime_error("Invalid Selection.");
                    }
                    else if(genderSelect == 1) {
                        currentGender = "Male";
                        cout << "Is pet neutered? Select:" << endl;
                        cout << "1. Yes" << endl;
                        cout << "2. No" << endl;
                        cin >> neuterSelect;
                        if(neuterSelect < 1 || neuterSelect > 2 || !cin) {
                            throw runtime_error("Invalid Selection.");
                        }
                        else if(neuterSelect == 1) {
                            currentRepro = "Neutered";
                        }
                        else if(neuterSelect == 2) {
                            currentRepro = "Intact";
                        }
                    }
                    else if(genderSelect == 2) {
                        currentGender = "Female";
                        cout << "Is pet spayed? Select:" << endl;
                        cout << "1. Yes" << endl;
                        cout << "2. No" << endl;
                        cin >> spaySelect;
                        if(spaySelect < 1 || spaySelect > 2 || !cin) {
                            throw runtime_error("Invalid Selection.");
                        }
                        else if(spaySelect == 1) {
                            currentRepro = "Spayed";
                        }
                        else if(spaySelect == 2) {
                            currentRepro = "Intact";
                        }
                    }
                    cout << "Please select where pet lives: " << endl;
                    cout << "1. Indoors" << endl;
                    cout << "2. Outdoors" << endl;
                    cout << "3. Indoors and Outdoors" << endl;
                    cin >> environSelect;
                    if(environSelect < 1 || environSelect > 3 || !cin) {
                        throw runtime_error("Invalid Selection.");
                    }
                    else if(environSelect == 1) {
                        currentEnviron = "Indoors";
                    }
                    else if(environSelect == 2) {
                        currentEnviron = "Outdoors";
                    }
                    else if(environSelect == 3) {
                        currentEnviron = "Indoors and Outdoors";
                    }

                    pets.emplace_back(make_unique<HousePet>(currentName, currentSpecies, currentBreed, currentAge, currentColor, currentRepro, currentGender, currentEnviron));
                }

                else if(addPetOption == 3) {  //Same as above 2, for PocketPet derived class
                    cout << "Add Pocket Pet Selected." << endl <<endl;
                    cout << "Please enter pet's name: ";
                    cin >> currentName;

                    cout << "Please enter pet's species: ";
                    cin >> currentSpecies;

                    cout << "Please enter pet's age, in years: ";
                    cin >> currentAge;
                    if(currentAge < 0 || !cin) {
                        throw runtime_error("Invalid Selection.");
                    }

                    cout << "Please enter pet's color: ";
                    cin >> currentColor;

                    cout << "Please enter bedding type: ";
                    cin >> currentBedding;

                    cout << "Please enter size of cage, in cubic feet: ";
                    cin >> currentCageSize;
                    if(currentCageSize < 0 || !cin) {
                        throw runtime_error("Invalid Selection.");
                    }
                    pets.emplace_back(make_unique<PocketPet>(currentName, currentSpecies, currentAge, currentColor, currentBedding, currentCageSize));
                }

            }
            else if(mainMenuSelection == 2) {  //Selects for removal of pet from list
                cout << "Remove pet from list selected." << endl;  //Confirms selection

                cout << "Please enter the index number of the entry to remove: " << endl;  //Prompts for index number

                cin >> index;  //Accepts input

                if(index < 0 || !cin) {  //Selects for errors, as before
                    throw runtime_error("Invalid Selection.");
                }
                pets.erase(pets.begin() + index);  //erases smart pointer selected
                cout << "Entry at index " << index << " has been removed." << endl;  //Confirms removal of entry at selected index
            }
            else if(mainMenuSelection == 3) {  //Selects for listing all entries
                for (auto& Pet: pets) {  //Lists info for all smart pointers in vector
                    cout << endl;
                    Pet->Print();
                }
            }
        }

        catch (runtime_error& excpt) {  //Catches any errors from invalid entries
            cout << excpt.what() << endl;
            cin.clear();
            cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
        }

        cout << endl << "Enter any key to continue or 'q' to quit: ";  //Prompts user to either continue or quit
        cin >> endProg;
    }
    return 0;
}
