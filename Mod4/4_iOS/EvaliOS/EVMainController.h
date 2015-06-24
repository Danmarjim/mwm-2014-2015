//
//  EVMainController.h
//  EvaliOS
//
//  Created by Daniel Martin Jimenez on 22/6/15.
//  Copyright (c) 2015 Daniel Martin Jimenez. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "UIColor+MyColor.h"
#import "EVMapController.h"
#import "EVWeatherAtm.h"

@interface EVMainController : UIViewController <UIPickerViewDelegate, UIPickerViewDataSource>

@property (weak, nonatomic) IBOutlet UIButton *buttonPicker;
@property (weak, nonatomic) IBOutlet UIButton *buttonService;
@property (weak, nonatomic) IBOutlet UIButton *buttonMap;
@property (weak, nonatomic) IBOutlet UILabel *labelTemp;
@property (weak, nonatomic) IBOutlet UILabel *labelTempMin;
@property (weak, nonatomic) IBOutlet UILabel *labelTempMax;
@property (weak, nonatomic) IBOutlet UILabel *labelDesc;
@property (weak, nonatomic) IBOutlet UILabel *labelWind;

@property (strong, nonatomic) UIPickerView *pickerCity;

-(IBAction)showPicker;
-(IBAction)callService;
-(IBAction)openMap;

@end
