import random

score=0

def init():
    while True:
        print("\n################")
        print(f"#Score: {score}    #")
        print("#   Options:   #")
        print("#    1-Play    #")
        print("#    2-Quit    #")
        print("################")    
        option=int(input("\nOption: "))
        if option==2:
            break
        elif option!=1:
            continue
        
        
        try:
            f_range=int(input("Enter the firt number (integer):"))
        except ValueError:
            print("[Warning] - Please enter a right first number\n")
            continue
        try:
            l_range=int(input("Enter the last number (integer):"))
        except ValueError:
            print("[Warning] - Please enter a right last number\n")
            continue
            
        guess_number=random.randint(f_range,l_range)
        print("%Random number generated%\n")
        print(":::::::::::::::::::::::::")
        trys=(l_range-f_range)//2
        print(f"Generated trys {trys}\n")
            
            
        while True:
            if trys==0:
                print("Trys lost!! Don't score :(")
                break
            try:
                guess=int(input(f'Enter your try {f_range,l_range}:'))
                if guess_number==guess:
                    print("Congratulations!!! YOU GUESSED IT! +1 to score")
                    break
                else:
                    if guess_number>guess:
                        print("Bigger!!")
                    else:
                        print("Smaller!!")
                        print("You failed, try again!")
                        trys-=1
                        print(f"Trys: {trys}")
                        continue
            except ValueError: 
                print("Put a integer please")
                trys-=1
                print(f"Trys: {trys}")
                continue
    
    print("\nGoodbye see you later!!")
                