GlowScript 3.0 VPython
#setup


spielfeld = box(size = vec(100, 50, 5))
tor_l = box(size = vec(10,30,5), 
            pos = vec(-45,0,0), 
            color = color.green)
tor_r = box(size = vec(10,30,5),
            pos = vec(+45,0,0),
            color = color.green)
puck = sphere(radius = 3, 
              color = color.red,
              pos = vec(-50,0,5))
attach_trail(puck, color = color.blue)

m = 0.375
b = -0

# x Startwert
puck.pos.x = -40
puck.pos.y = -15

# game loop
fr = 30 #framerate

#Spiel läuft
laeuft = True
while laeuft: 
  rate(fr)
  
  puck.pos.x = puck.pos.x+1
  #Geradengleichung y=m*x+b
  puck.pos.y = m*puck.pos.x + b
  
  #falls Puck außerhalb Spielfeld: abbrechen
  if puck.pos.x > 50 or puck.pos.x <-50:
    laeuft = False