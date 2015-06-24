//
//  EVWeatherAtm.h
//  EvaliOS
//
//  Created by Daniel Martin Jimenez on 24/6/15.
//  Copyright (c) 2015 Daniel Martin Jimenez. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface EVWeatherAtm : NSObject

@property (strong, nonatomic) NSNumber *speed;
@property (strong, nonatomic) NSNumber *temperature;
@property (strong, nonatomic) NSNumber *temperatureMax;
@property (strong, nonatomic) NSNumber *temperatureMin;
@property (strong, nonatomic) NSArray *descrip;

@end
