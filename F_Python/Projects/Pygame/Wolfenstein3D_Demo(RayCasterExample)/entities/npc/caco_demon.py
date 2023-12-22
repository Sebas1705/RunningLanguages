from entities.npc.npc import NPC

class CacoDemon(NPC):
    
    def __init__(self,game,path="resources/sprites/npc/caco_demon/0.png",
                 pos=(10.5,6.5),scale=0.7,shift=0.27,animation_time=180):
        super().__init__(game,path,pos,scale,shift,animation_time)
        self.attack_dist=1
        self.speed=0.05
        self.health=150
        self.attack_damage=25
        self.accuracy=0.35

 