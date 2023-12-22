from graphics.sprite_object import *
from entities.npc.soldier import Soldier
from entities.npc.caco_demon import CacoDemon
from entities.npc.cyber_demon import CyberDemon
from random import choices, randrange

class ObjectHandler:
    
    def __init__(self,game):
        self.game = game
        self.sprite_list = []
        self.npc_list=[]
        self.npc_sprite_path="resources/sprites/npc/"   
        self.static_sprite_path="resources/sprites/static_sprites/"
        self.anim_sprite_path="resources/sprites/animated_sprites/"
        self.npc_positions={}
        self.npc_types = [Soldier,CacoDemon,CyberDemon]
        self.restricted_area = {(i, j) for i in range(10) for j in range(10)} #Player spawn protected area
        
        # spawn entities
        self.spawn_npc()
        self.spawn_animated_sprite()

    
    def spawn_animated_sprite(self):
        objects_anim=self.game.map.level_info["objects_anim"]
        for name,positions in objects_anim.items():
            for posStr in positions.split("-"):
                pos=posStr.split(",")
                pos=float(pos[0]),float(pos[1])
                self.add_sprite(AnimatedSprite(self.game,path=self.anim_sprite_path+name+"/0.png",pos=pos))
        
    def spawn_npc(self):
        for i in range(self.game.map.level_info["enemies"]):
            npc = choices(self.npc_types,self.game.map.level_info["enemies_weights"])[0]
            pos = x, y = randrange(self.game.map.cols),randrange(self.game.map.rows)
            while (pos in self.game.map.world_map) or (pos in self.restricted_area):
                pos = x, y = randrange(self.game.map.cols), randrange(self.game.map.rows)
            self.add_npc(npc(self.game, pos=(x+0.5,y+0.5)))

    def check_win(self):
        if not len(self.npc_positions):
            self.game.object_renderer.win()
            pg.display.flip()
            pg.time.delay(1500)
            self.game.new_game()
    
    def update(self):
        self.npc_positions={npc.map_pos for npc in self.npc_list if npc.alive}
        [sprite.update() for sprite in self.sprite_list]
        [npc.update() for npc in self.npc_list]
        self.check_win()
        
    def add_npc(self,npc):
        self.npc_list.append(npc)
        
    def add_sprite(self,sprite):
        self.sprite_list.append(sprite)