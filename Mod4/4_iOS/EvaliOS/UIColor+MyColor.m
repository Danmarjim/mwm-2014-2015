//
//  UIColor+MyColor.m
//  EvaliOS
//
//  Created by Daniel Martin Jimenez on 22/6/15.
//  Copyright (c) 2015 Daniel Martin Jimenez. All rights reserved.
//

#import "UIColor+MyColor.h"

@implementation UIColor (MyColor)

+ (instancetype)customColor
{
    return [UIColor colorWithRed:214.0/255.0 green:71.0/255.0 blue:57.0/255.0 alpha:1.0];
}

+ (instancetype)customColorAlertView
{
    return [UIColor colorWithRed:250.0/255.0 green:206.0/255.0 blue:40.0/255.0 alpha:1.0];
}

+ (instancetype)customColorTextAlert
{
    return [UIColor colorWithRed:49.0/255.0 green:49.0/255.0 blue:49.0/255.0 alpha:0.5];
}

@end
