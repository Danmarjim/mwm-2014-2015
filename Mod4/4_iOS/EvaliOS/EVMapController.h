//
//  EVMapController.h
//  EvaliOS
//
//  Created by Daniel Martin Jimenez on 24/6/15.
//  Copyright (c) 2015 Daniel Martin Jimenez. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <MapKit/MapKit.h>
#import <MapKit/MKAnnotation.h>
#import "UIColor+MyColor.h"
#import "SSBouncyButton.h"

@interface EVMapController : UIViewController <MKMapViewDelegate,  CLLocationManagerDelegate>

@property (strong, nonatomic) NSNumber *lat;
@property (strong, nonatomic) NSNumber *lon;
@property (strong, nonatomic) NSString *city;

@property (weak, nonatomic) IBOutlet MKMapView *mapView;
@property (weak, nonatomic) IBOutlet SSBouncyButton *customButton;

-(IBAction)buttonDidPress:(UIButton *)button;

@end
