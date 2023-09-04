import pygame,time,random,sys

#Consts:
background_color=(0,0,0)
x,y=0,1
boxes=(10,10)
size=(500,500)
tam=(size[x]/boxes[x],size[y]/boxes[y])
screen=pygame.display.set_mode(size)
clock=pygame.time.Clock()
recordFile="./1-Python/Pygame/Snake/data/record.txt"
appleImg="1-Python/Pygame/Snake/img/apple.png"
headImg="1-Python/Pygame/Snake/img/head.png"
bodyImg="1-Python/Pygame/Snake/img/body.png"

#Events
move_event=pygame.USEREVENT
pygame.time.set_timer(move_event,300)
  
class Snake:
    def __init__(self,x,y,size,image_body,image_head):
        self.posibleDir=("up","down","left","right")
        self.dir=random.choice(self.posibleDir)
        self.tam=size
        self.image_body=pygame.transform.scale(image_body,tam)
        self.image_head=pygame.transform.scale(image_head,tam)
        self.pos=[(x,y) for i in range(size)]
    def inc_size(self):
        self.tam+=1
        self.pos.append(self.pos[self.tam-2])
    def go(self):
        if self.dir==self.posibleDir[0]:
            new_pos=(self.pos[0][x],((self.pos[0][y]-tam[y])%size[y]))
            self.pos.pop()
            self.pos.insert(0,new_pos)
        elif self.dir==self.posibleDir[1]:
            new_pos=(self.pos[0][x],((self.pos[0][y]+tam[y])%size[y]))
            self.pos.pop()
            self.pos.insert(0,new_pos)
        elif self.dir==self.posibleDir[2]:
            new_pos=(((self.pos[0][x]-tam[x])%size[x]),self.pos[0][y])
            self.pos.pop()
            self.pos.insert(0,new_pos)
        elif self.dir==self.posibleDir[3]:
            new_pos=(((self.pos[0][x]+tam[x])%size[x]),self.pos[0][y])
            self.pos.pop()
            self.pos.insert(0,new_pos)  
    def change_dir(self,direction):
        if (direction==self.posibleDir[0] and self.dir!=self.posibleDir[1]) or (direction==self.posibleDir[1] and self.dir!=self.posibleDir[0]) or (direction==self.posibleDir[2] and self.dir!=self.posibleDir[3]) or (direction==self.posibleDir[3] and self.dir!=self.posibleDir[2]):
            self.dir=direction
    def collideApple(self,apple):
        return apple.x==self.pos[0][x] and apple.y==self.pos[0][y]
    def collideItSelf(self):
        for pos in self.pos[1:]:
            if self.pos[0][x]==pos[x] and self.pos[0][y]==pos[y]:
                return True
        return False
    def draw(self):
        for i in range(self.tam):
            if i==0:
                if self.dir==self.posibleDir[0]:
                    screen.blit(pygame.transform.rotate(self.image_head,180),self.pos[i])
                elif self.dir==self.posibleDir[1]:
                    screen.blit(self.image_head,self.pos[i])
                elif self.dir==self.posibleDir[2]:
                    screen.blit(pygame.transform.rotate(self.image_head,270),self.pos[i])
                elif self.dir==self.posibleDir[3]:
                    screen.blit(pygame.transform.rotate(self.image_head,90),self.pos[i])
            else:
                screen.blit(self.image_body,self.pos[i])
        
class Apple:
    def __init__(self,x,y,image):
        self.x=x
        self.y=y
        self.image=pygame.transform.scale(image,tam)     
    def draw(self):
        screen.blit(self.image,(self.x,self.y))  
    def random_spawn(self,snake):
        equal=True
        while equal:
            self.x=random.randint(0,9)*50
            self.y=random.randint(0,9)*50
            
            for pos in snake.pos:
                if pos[x]==self.x and pos[y]==self.y:
                    equal=True
                    break
                else:
                    equal=False                    
        

def init():

    #images:
    apple_img=pygame.image.load(appleImg).convert()
    body_img=pygame.image.load(bodyImg).convert()
    head_img=pygame.image.load(headImg).convert()

    #Objects:
    apple=Apple(100,100,apple_img)
    snake=Snake(random.randint(0,9)*50,random.randint(0,9)*50,1,body_img,head_img)
    apple.random_spawn(snake)
    
    record=0
    try:
        with open(recordFile) as f:
            record=int(f.read())
    except FileNotFoundError as err:
        print(f"Err: {err}")
    finally:
        f.close()
    score=0
    pygame.init()    
    while True:
        
        screen.fill(background_color)
        apple.draw()
        snake.draw()
        f30=pygame.font.SysFont("Arial",30)
        score_text=f30.render("Score: "+str(score),0,(255,255,255),None)
        record_text=f30.render("Record: "+str(record),0,(255,255,255),None)
        screen.blit(score_text,(0,0))
        screen.blit(record_text,(350,0))
        pygame.display.update()
        
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_UP:
                    snake.change_dir("up")
                elif event.key == pygame.K_DOWN:
                    snake.change_dir("down")
                elif event.key == pygame.K_RIGHT:
                    snake.change_dir("right")
                elif event.key == pygame.K_LEFT:
                    snake.change_dir("left")
            elif event.type == move_event:
                snake.go()
                if snake.collideItSelf():
                    if score>record:
                        try:
                            with open(recordFile,"w") as f:
                                f.write(str(score))
                        except FileNotFoundError as err:
                            print(f"Err {err}")
                        finally:
                            f.close()
                    pygame.quit()
                    sys.exit()
                elif snake.collideApple(apple):
                    snake.inc_size()
                    apple.random_spawn(snake)  
                    score+=10
        clock.tick(60)
        
                
    
init()