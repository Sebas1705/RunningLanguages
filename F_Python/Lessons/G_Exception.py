
# try:
#     print("Num: "+str(int(input("Num: \n->"))))
# except Exception:
#     print("[ERROR] - An error has occurred")    
# else:
#     print("All correct")
# finally:
#     print("Always gone")
    

# while True:
#     try:
#         res=float(input("Num1: "))/float(input("Num2: "))
#         print(f"Resultado: {res:.2f}")
#     except ValueError:
#         print("[ERROR] - Values had incorrectly entered")
#     except ZeroDivisionError:
#         print("[ERROR] - Can't be divided by zero")
#     else:
#         break
    
def no_negative(num):
    if(num<0):
        raise ValueError("[ERROR] - Not negative values")

try:
    no_negative(-100)
except ValueError as Error:
    print(Error)