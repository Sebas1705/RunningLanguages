from entities.npc.npc import NPC

class CyberDemon(NPC):
    
    def __init__(self,game,path="resources/sprites/npc/cyber_demon/0.png",
                 pos=(11.5,6.0),scale=1.0,shift=0.04,animation_time=180):
        super().__init__(game,path,pos,scale,shift,animation_time)
        self.attack_dist=6
        self.speed=0.055
        self.health=200
        self.attack_damage=15
        self.accuracy=0.25
      