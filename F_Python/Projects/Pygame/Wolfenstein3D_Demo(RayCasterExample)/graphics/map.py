import pygame as pg
import json
from settings import *

class Map:
    
    def __init__(self, game):
        self.game = game
        self.maps_data=self.get_maps_data()
        self.level_info=self.maps_data["levels"][self.game.level]
        self.game.n_levels=len(self.maps_data["levels"])
        self.mini_map=self.level_info["map"]
        self.world_map = {}
        self.rows =len(self.mini_map)
        self.cols =len(self.mini_map[0])
        self.get_map()
        
    def get_maps_data(self):
        info={}
        with open(PATH_PROJECT+'data/maps.json','r') as json_file:
            info=json.load(json_file)
        return info
    
    def get_map(self):
        for j, row in enumerate(self.mini_map):
            for i, value in enumerate(row):
                if int(value)!=0:
                    self.world_map[(i,j)] = int(value)
                self.mini_map[j][i]=int(self.mini_map[j][i])
    
    def draw(self):
        [pg.draw.rect(self.game.screen, 'darkgray', (pos[0]*100, pos[1]*100, 100, 100),2)
         for pos in self.world_map]