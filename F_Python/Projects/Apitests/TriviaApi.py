import requests
from googletrans import Translator

translator = Translator()
url = "https://opentdb.com/api.php?amount=1&category=9&type=boolean"
points = 0

next=True
while(next==True):
    
    response = requests.get(url).json()

    if response["response_code"]!=0:
        print("Bad request, intentandolo de nuevo...")
        continue
        
    question = response["results"][0]

    print("----------------------------------------------")
    print(f"Question: {translator.translate(question["question"], src='en', dest='es').text}\n")
    res = input("V/F:")

    if (
        (question["correct_answer"]=="True" and (res in ["T","V","t","v"]))
        or
        (question["correct_answer"]=="False" and (res in ["F","f"]))
    ):
        print("Bien!!! +1")
        points+=1
    else:
        print(f"Fallada :( -1, correcto: {question["correct_answer"]}")
        points: int = 0 if points==0 else points-1
    
    next: str = "" == input("\n¿Quieres continuar?(Enter:Si, Cualquiera:No): ")

print("\n\n*******************************************")
print(f"*\tPuntuación final: {points}!\t*")
print("*******************************************")
