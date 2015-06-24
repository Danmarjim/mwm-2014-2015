//
//  EVLoginController.h
//  EvaliOS
//
//  Created by Daniel Martin Jimenez on 22/6/15.
//  Copyright (c) 2015 Daniel Martin Jimenez. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "CustomIOSAlertView.h"
#import "UIColor+MyColor.h"

@interface EVLoginController : UIViewController

@property (nonatomic, strong) CustomIOSAlertView *alertView;
@property (weak, nonatomic) IBOutlet UIImageView *imageView;
@property (weak, nonatomic) IBOutlet UIButton *buttonIn;
@property (weak, nonatomic) IBOutlet UITextField *userField;
@property (weak, nonatomic) IBOutlet UITextField *pwdField;

-(IBAction)logIn;

@end
