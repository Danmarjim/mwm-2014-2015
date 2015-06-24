//
//  EVMapController.m
//  EvaliOS
//
//  Created by Daniel Martin Jimenez on 24/6/15.
//  Copyright (c) 2015 Daniel Martin Jimenez. All rights reserved.
//

#import "EVMapController.h"

@interface EVMapController ()

@end

@implementation EVMapController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    [self setItems];
}

-(void)setItems
{
    //TITULO
    NSString *title = @"Mapa de ";
    NSArray *characters = [self.city componentsSeparatedByString:@","];
    NSString *nameMap = [characters objectAtIndex:0];
    self.title = [title stringByAppendingString:nameMap];
    
    self.mapView.delegate = self;
    [self.mapView setMapType:MKMapTypeStandard];
    [self.mapView setZoomEnabled:YES];
    [self.mapView setScrollEnabled:YES];
    
    MKCoordinateSpan span;
    span.latitudeDelta = 0.002;
    span.longitudeDelta = 0.002;
    
    CLLocationCoordinate2D start;
    start.latitude = [self.lat doubleValue];
    start.longitude = [self.lon doubleValue];
    
    MKCoordinateRegion region;
    region.span = span;
    region.center = start;
    
    [self.mapView setRegion:region animated:YES];
    
    self.customButton.tintColor = [UIColor whiteColor];
    self.customButton.backgroundColor = [UIColor customColor];
    [self.customButton setTitle:@"Satélite" forState:UIControlStateNormal];
    [self.customButton setTitle:@"Estandar" forState:UIControlStateSelected];
}

-(IBAction)buttonDidPress:(UIButton *)button
{
    button.selected = !button.selected;
    
    if([self.mapView mapType] == MKMapTypeSatellite){
        [self.mapView setMapType:MKMapTypeStandard];
    } else {
       [self.mapView setMapType:MKMapTypeSatellite];
    }
}


@end
